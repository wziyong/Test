package sort;

/*
 冒泡排序的原理非常简单，它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
步骤：
比较相邻的元素。如果第一个比第二个大，就交换他们两个。
对第0个到第n-1个数据做同样的工作。这时，最大的数就“浮”到了数组最后的位置上。
针对所有的元素重复以上的步骤，除了最后一个。
持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。


不过针对上述代码还有两种优化方案。

优化1：某一趟遍历如果没有数据交换，则说明已经排好序了，因此不用再进行迭代了。用一个标记记录这个状态即可。
优化2：记录某次遍历时最后发生数据交换的位置，这个位置之后的数据显然已经有序，不用再排序了。因此通过记录最后发生数据交换的位置就可以确定下次循环的范围了。

*/
public class 冒泡排序
{
	public static void bubbleSort(int[] data)
	{
		int tmp = 0;
		for (int i = 0; i < data.length; i++)
		{
			for (int j = 0; j < data.length - i - 1; j++) // 注意减1
			{
				if (data[j] > data[j + 1])// 如果当前大于后面的元素，则交换
				{
					tmp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = tmp;
				}
			}
		}
	}

	// 下面对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
	// 冒泡排序2
	public static void bubbleSort2(int[] data)
	{
		int tmp = 0;
		for (int i = 0; i < data.length - 1; i++)
		{
			// 记录某趟是否发生交换，若为false表示数组已处于有序状态
			boolean isSorted = false;
			for (int j = 0; j < data.length - i - 1; j++)
			{
				if (data[j] > data[j + 1])
				{
					tmp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = tmp;

					isSorted = true;
				}
			}
			if (!isSorted)
			{
				// 若数组已处于有序状态，结束循环
				break;
			}
		}
	}

}
