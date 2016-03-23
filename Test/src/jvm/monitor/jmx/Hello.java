package jvm.monitor.jmx;

public class Hello implements HelloMBean
{

	String name = "";

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{

		this.name = name;
	}

	@Override
	public void printHello()
	{
		System.out.println("hello world ," + name);
	}

	@Override
	public void printHello(String whoName)
	{

		System.out.println("Hello , " + whoName);

	}

}
