package sort;

public class 直接插入排序
{
	public static void main(String[] args)
	{
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
		// 直接插入排序
		for (int i = 1; i < a.length; i++)
		{
			// 待插入元素
			int temp = a[i];
			int j;

			for (j = i - 1; j >= 0; j--)
			{
				// 将大于temp的往后移动一位
				if (a[j] > temp)
				{
					a[j + 1] = a[j];
				}
				else
				{
					break;
				}
			}
			a[j + 1] = temp;
		}
	}

}
