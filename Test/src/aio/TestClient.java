package aio;

import org.junit.Test;

public class TestClient
{

	@Test
	public void testClient() throws Exception
	{
		SimpleClient client = new SimpleClient("127.0.0.1", 8086);
		for (int i = 0; i < 3; i++)
		{
			int x = i + 10000;
			client.write((byte) i);
		}
	}

}
