package datastructrue.list.priorityqueue;

import java.util.Comparator;
import java.util.MissingFormatArgumentException;
import java.util.PriorityQueue;

public class ProrityQueueTest
{
	public static void main(String[] args)
	{
		Comparator<Bean> comparator = new Comparator<Bean>()
		{
			@Override
			public int compare(Bean o1, Bean o2)
			{
				if (o1.getAge() >= o2.getAge())
				{
					return 1;
				}
				return -1;
			}
		};

		PriorityQueue<Bean> queue = new PriorityQueue<>(3, comparator);

		Bean b0 = new Bean("b0", 0);
		Bean b1 = new Bean("b1", 1);
		Bean b2 = new Bean("b2", 2);
		Bean b3 = new Bean("b3", 3);
		Bean b4 = new Bean("b4", 4);
		Bean b5 = new Bean("b5", 5);
		Bean b6 = new Bean("b6", 6);

		queue.add(b6);
		queue.add(b2);
		queue.add(b1);
		queue.add(b0);
		queue.add(b4);
		queue.add(b5);
		Bean tmp = null;
		while ((tmp = queue.poll()) != null)
		{
			System.out.println(tmp.getName());

		}

	}
}
