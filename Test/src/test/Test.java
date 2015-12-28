package test;

public class Test
{

	public static int x()
	{
		int x = 0;
		try
		{
			x = 1;
			return x;

		}
		catch (Exception e)
		{
			return -1;
		}
		finally
		{
			x = 3;
			System.out.println(3333);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(x());
	}
}
