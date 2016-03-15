package test.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("server start ...");
			ServerSocket server = new ServerSocket(8080);

			// 使用accept()阻塞等待客户请求，有客户
			// 请求到来则产生一个Socket对象，并继续执行
			Socket socket = server.accept();

			String line = null;

			// 由Socket对象得到输入流，并构造相应的BufferedReader对象
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 由Socket对象得到输出流，并构造PrintWriter对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());

			// 由系统标准输入设备构造BufferedReader对象
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			// 在标准输出上打印从客户端读入的字符串
			System.out.println("Client:" + is.readLine());

			line = sin.readLine();

			while (!line.equals("bye"))
			{
				// 向客户端输出该字符串
				os.println(line);

				os.flush();

				System.err.println("Server:" + line);

				System.out.println("Client:" + is.readLine());

				line = sin.readLine();
			}

			os.close(); // 关闭Socket输出流
			is.close(); // 关闭Socket输入流
			socket.close(); // 关闭Socket
			server.close(); // 关闭ServerSocket
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
