package vm.gc;

import java.util.ArrayList;
import java.util.List;

public class FullGC
{
	public static void main(String[] args) throws Exception
	{
		List<MemoryObject> objects = new ArrayList<MemoryObject>(6);
		for (int i = 0; i < 10; i++)
		{
			objects.add(new MemoryObject(1024 * 1024));
		}
		// 让上面的对象尽可能地转入旧生代中
		System.out.println("111xxxxxxxxxxxx");
		System.gc();
		System.out.println("222xxxxxxxxxxxx");
		System.gc();
		Thread.sleep(2000);
		objects.clear();
		for (int i = 0; i < 10; i++)
		{
			objects.add(new MemoryObject(1024 * 1024));
			if (i % 3 == 0)
			{
				objects.remove(0);
			}
		}
		Thread.sleep(5000);
	}
}
