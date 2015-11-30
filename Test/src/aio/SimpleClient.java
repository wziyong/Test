package aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class SimpleClient
{
	private AsynchronousSocketChannel client = null;

	public SimpleClient(String host, int port) throws Exception
	{
		this.client = AsynchronousSocketChannel.open();
		Future<?> future = this.client.connect(new InetSocketAddress(host, port));
		future.get();
	}

	public void write(byte b)
	{
		ByteBuffer bf = ByteBuffer.allocate(1);
		bf.put(b);
		bf.flip();
		client.write(bf);
	}
}
