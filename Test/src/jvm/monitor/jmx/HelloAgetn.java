package jvm.monitor.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

public class HelloAgetn
{
	public static void main(String[] args) throws Exception
	{

		MBeanServer server = MBeanServerFactory.createMBeanServer();

		ObjectName helloName = new ObjectName("wzy:name=HelloWorld");
		server.registerMBean(new Hello(), helloName);

		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
		HtmlAdaptorServer  adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);

		adapter.start();
		System.out.println("start.....");

	}

}
