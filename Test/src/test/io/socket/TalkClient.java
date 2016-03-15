package test.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket socket = new Socket("127.0.0.1", 8080);

			// 由系统标准输入设备构造BufferedReader对象
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			// 由Socket对象获得输出流
			PrintWriter os = new PrintWriter(socket.getOutputStream());

			// 获得输入流
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String readline = null;

			// 从系统标准输入读入一字符串
			readline = sin.readLine();
			while (!readline.equals("bye"))
			{
				// 将从系统标准输入读入的字符串输出到Server
				os.println(readline);

				// 刷新输出流，使Server马上收到该字符串
				os.flush();

				System.out.println("Client:" + readline);

				// 从Server读入一字符串，并打印到标准输出上
				System.out.println("Server:" + is.readLine());

				readline = sin.readLine();
			}

			os.close(); // 关闭Socket输出流
			is.close(); // 关闭Socket输入流
			socket.close(); // 关闭Socket
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
