package aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class SimpleServer
{

	public SimpleServer(int port) throws Exception
	{

		final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open();

		listener.bind(new InetSocketAddress(port));

		listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>()
		{
			@Override
			public void completed(AsynchronousSocketChannel ch, Void attachment)
			{
				// 接受下一个连接
				listener.accept(null, this);
				System.out.println("completed");
				// 处理当前连接
				handle(ch);
			}

			@Override
			public void failed(Throwable exc, Void attachment)
			{
				// TODO Auto-generated method stub

			}

		});

	}

	private void handle(AsynchronousSocketChannel ch)
	{

		ByteBuffer bf = ByteBuffer.allocate(10);

		try
		{
			ch.read(bf).get();
		}
		catch (InterruptedException | ExecutionException e)
		{
			e.printStackTrace();
		}

		bf.flip();
		System.out.println(bf.get());

	}

}
