package sort;

/**
 * 大顶堆 http://blog.csdn.net/apei830/article/details/6584645
 *
 * ① 初始化操作：将R[1..n]构造为初始堆；
 * 
 * ② 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆(亦称重建堆)。
 * 
 * 注意： ①只需做n-1趟排序，选出较大的n-1个关键字即可以使得文件递增有序。
 * 
 */
public class 堆排序
{
	public static void main(String[] args)
	{
		int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		print(data5);
		heapSort(data5);
		System.out.println("排序后的数组：");
		print(data5);
	}

	public static void swap(int[] data, int i, int j)
	{
		if (i == j)
		{
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	public static void heapSort(int[] data)
	{
		for (int i = 0; i < data.length; i++)
		{
			buildMaxHeap(data, data.length - 1 - i);
			swap(data, 0, data.length - 1 - i);
		}
	}

	// 一般都用数组来表示堆，i结点的父下标就为(i – 1) / 2
	// 它的左右子结点下标分别为2 * i + 1和2 * i + 2。

	// 对data数组从0到lastIndex建大顶堆
	public static void buildMaxHeap(int[] data, int lastIndex)
	{
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--)
		{
			// k保存正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex)
			{
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex)
				{
					// 若果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1])
					{
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (data[k] < data[biggerIndex])
				{
					// 交换他们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				}
				else
				{
					break;
				}
			}
		}
	}

	public static void print(int[] data)
	{
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	}

}
