package vm;

public class SubInitField extends SuperInitField
{

	public SubInitField()
	{
		System.out.println("child init");

	}

	static
	{
		System.out.println("child static");
	}

}
