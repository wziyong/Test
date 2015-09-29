
public class Test
{

	public static void main(String[] args)
	{
		String xx = " cat_id = 286 or  cat_id = 286 or cat_id = 286 or cat_id = 285 or";
		
		System.out.println(xx.substring(0, xx.lastIndexOf("or")));
	}
}
