package vm;

public class XX
{
	public XX()
	{
		this("X");
		System.out.println("parent");
	}
	
	public XX(String x)
	{
		System.out.println("parent X");
	}

	static
	{
		System.out.println("static parent");
	}

	public static void main(String[] args)
	{
		XX xx = new XX();
	}
}
