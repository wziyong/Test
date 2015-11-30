package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class SocketTest {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket xx = new Socket("127.0.0.1",7999);
		
	 	OutputStream os =  xx.getOutputStream();
	 	PrintWriter pw = new PrintWriter(os);
	 	
	 	InputStream is = xx.getInputStream();
	 	BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
	 	
	 	String cmd = "{servertype=1,optype=11,args={app_http_port=8080,app_log_level=0}}";
	 	
	 	pw.write(cmd);
	 	pw.flush();
	 	xx.shutdownOutput();  
	 	
	 	
	 	String reply = null;
	 	while(!((reply=bfr.readLine())==null))
        {
	         System.out.println(reply);
        }
	 	
	 	os.close();
	 	pw.close();
	 	is.close();
	 	bfr.close();

	}

}
