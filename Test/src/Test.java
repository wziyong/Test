import java.util.LinkedHashMap;
import java.util.Map;

public class Test
{

	public static void main(String[] args)
	{

		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");

		
		map.containsValue("2");
		for (String x : map.keySet())
		{
			System.out.println(x);
		}
	}
}
