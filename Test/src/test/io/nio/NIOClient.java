package test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOClient
{

	private Selector selector;

	public void initClient(String ip, int port) throws IOException
	{
		SocketChannel channel = SocketChannel.open();

		channel.configureBlocking(false);

		this.selector = Selector.open();

		// 客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调
		// 用channel.finishConnect();才能完成连接
		channel.connect(new InetSocketAddress(ip, port));

		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	// 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
	public void listen() throws IOException
	{
		while (true)
		{
			selector.select();

			Iterator ite = this.selector.selectedKeys().iterator();

			while (ite.hasNext())
			{
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();

				if (key.isConnectable())
				{
					SocketChannel channel = (SocketChannel) key.channel();

					// 如果正在连接，则完成连接
					if (channel.isConnectionPending())
					{
						channel.finishConnect();
					}
					channel.configureBlocking(false);

					// 在这里可以给服务端发送信息哦
					channel.write(ByteBuffer.wrap(new String("client sent to server a message").getBytes()));

					// 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
					channel.register(this.selector, SelectionKey.OP_READ);
				}
				else if (key.isReadable())
				{
					// 和服务器端的写法一样

					// 服务器可读取消息，得到事件发生的Socket通道
					SocketChannel channel = (SocketChannel) key.channel();

					// 创建读取缓冲区
					ByteBuffer buffer = ByteBuffer.allocate(10);
					channel.read(buffer);
					byte[] data = buffer.array();

					String msg = new String(data).trim();
					System.out.println("server recive：" + msg);

					ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
					channel.write(outBuffer);// 将消息会送给客户端
				}
			}
		}
	}

	/**
	 * 启动客户端测试
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		NIOClient client = new NIOClient();
		client.initClient("localhost", 8080);
		client.listen();
	}
}
