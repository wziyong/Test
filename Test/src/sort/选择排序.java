package sort;

public class 选择排序
{

	public static void selectSort(int[] data)
	{
		for (int i = 0; i < data.length - 1; i++)
		{
			int minIndex = i; // 记录最小值的索引
			for (int j = i + 1; j < data.length; j++)
			{
				if (data[j] < data[minIndex])
				{
					minIndex = j; // 若后面的元素值小于最小值,将j赋值给minIndex
				}
			}
			
			if (minIndex != i)
			{
				// Swap(data, i, minIndex);//选择一个然后交换~
			}
			
		}
	}
}
