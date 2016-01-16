package vm.compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTypeTest
{
	public static void main(String[] args)
	{
		Integer a =1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		Integer e=321;
		Integer f=321;
		Long g = 3L;
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(c==(a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g==(a+b));
		System.out.println(g.equals(a+b));
	}
	
	

/*	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<String, String>();

		map.put("Key1", "value1");
		System.out.println(map.get("Key1"));
	}*/
	
/*	public int x()
	{
	
		return 1;
	}
	public String x()
	{
		return null;
	}
	*/
	
	/*
	 * 不能被编译
	 * 
	 * public static void method(List<String> x) {
	 * 
	 * }
	 * 
	 * public static void method(List<Integer> x) {
	 * 
	 * }
	 */

}
