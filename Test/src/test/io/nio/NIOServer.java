package test.io.nio;

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

	// 管道管理器
	private Selector selector = null;

	// 获得一个ServerSocket通道，并对该通道做一些初始化的工作
	public void initServer(int port) throws IOException
	{

		// 获得一个ServerSocket通道
		ServerSocketChannel serverChannel = ServerSocketChannel.open();

		// 设置通道为非阻塞
		serverChannel.configureBlocking(false);

		// 获得与serverChanel绑定的socket，并设置该ServerSocket的IP和端口
		serverChannel.socket().bind(new InetSocketAddress(port));

		// 获得一个通道管理器
		this.selector = Selector.open();

		// 将管道管理器与该通道绑定，并未改通道注册Accept事件。
		// 注册该事件后，该事件到达时，selector.select()会返回，如果该事件没有到达，
		// selector.select()会一直阻塞
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);

	}

	public void listen() throws IOException
	{
		System.out.println("server start ....");

		// 死循环，轮询selector的事件
		while (true)
		{
			// 当注册的事件到达时，方法返回；否则,该方法会一直阻塞，返回key的数量
			selector.select();

			// 获得selector中选中的项的迭代器，选中的项为注册的事件
			Iterator ite = this.selector.selectedKeys().iterator();

			while (ite.hasNext())
			{
				SelectionKey key = (SelectionKey) ite.next();

				// 删除已选的key，以防止重复处理
				ite.remove();

				// 等于k.readyOps() & OP_ACCEPT != 0
				if (key.isAcceptable())
				{
					ServerSocketChannel server = (ServerSocketChannel) key.channel();

					// 获得客户端连接的通道,并设置为非阻塞的
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);

					// 向客户端发送消息
					channel.write(ByteBuffer.wrap(new String("server sent to client a message").getBytes()));

					// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
					channel.register(this.selector, SelectionKey.OP_READ);

				}
				else if (key.isReadable())
				{
					read(key);
				}
			}

		}
	}

	// 处理读取客户端发来的信息 的事件
	public void read(SelectionKey key) throws IOException
	{
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

	public static void main(String[] args) throws IOException
	{
		NIOServer server = new NIOServer();
		server.initServer(8080);
		server.listen();
	}

}
