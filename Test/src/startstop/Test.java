package startstop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test {
	
	public static void main(String[] args) {
		try {
			Process p = Runtime.getRuntime().exec("sh /home/wziyong/develop/apache-tomcat-7.0.64/bin/startup.sh");
			OutputStream os = p.getOutputStream();
			InputStream is = p.getInputStream();
			
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
			
			String line  = "";
			while((line=bfr.readLine()) != null )
			{
				System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
