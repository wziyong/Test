package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer
{
	// 通道管理器
	private Selector selector;

	public void initServer(int port) throws Exception
	{
		// 获得一个ServerSocket通道
		ServerSocketChannel ssc = ServerSocketChannel.open();
		// 设置通道为非阻塞 ;与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以

		ssc.configureBlocking(false);
		// 将该通道对应的ServerSocket绑定到port端口
		ssc.socket().bind(new InetSocketAddress(port));
		// 获得一个通道管理器
		this.selector = Selector.open();

		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
		// 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
		ssc.register(this.selector, SelectionKey.OP_ACCEPT);
	}

	public void listen() throws Exception
	{
		System.out.println("server start");
		// 轮询访问selector
		while (true)
		{
			// 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
			// select()阻塞到至少有一个通道在你注册的事件上就绪了。
			selector.select();

			// 获得selector中选中的项的迭代器，选中的项为注册的事件
			Iterator ite = this.selector.selectedKeys().iterator();

			while (ite.hasNext())
			{
				SelectionKey key = (SelectionKey) ite.next();
				// 删除已选的key,以防重复处理
				ite.remove();

				// 客户端请求连接事件
				if (key.isAcceptable())
				{
					ServerSocketChannel server = (ServerSocketChannel) key.channel();

					SocketChannel channel = server.accept();
					channel.configureBlocking(false);

					// 在这里可以给客户端发送信息
					channel.write(ByteBuffer.wrap("server to client".getBytes()));

					// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
					channel.register(this.selector, SelectionKey.OP_READ);
					// 获得了可读的事件
				}
				else if (key.isReadable())
				{
					read(key);
				}

			}

		}

	}

	/**
	 * 处理读取客户端发来的信息 的事件
	 * 
	 * @param key
	 * @throws IOException
	 */
	public void read(SelectionKey key) throws IOException
	{
		// 服务器可读取消息:得到事件发生的Socket通道
		SocketChannel channel = (SocketChannel) key.channel();
		// 创建读取的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("服务端收到信息：" + msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);// 将消息回送给客户端
	}

}
