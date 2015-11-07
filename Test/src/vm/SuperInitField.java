package vm;

public class SuperInitField
{

	public SuperInitField()
	{
		System.out.println("parent init");
	}

	static
	{
		System.out.println("parent static ");
	}

}
