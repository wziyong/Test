package aio;

import org.junit.Test;

public class TestServer
{
	
	@Test
	public void testServer() throws Exception
	{
		SimpleServer server = new SimpleServer(8086);
		
		Thread.sleep(2000000);
	}

	
}
