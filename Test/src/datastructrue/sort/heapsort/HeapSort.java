package datastructrue.sort.heapsort;

/**
 * 大顶堆
 * 
 * @author wziyong
 *
 */
public class HeapSort
{
	private void heapSort(int[] h)
	{
		// 对顺序表H进行堆排序，生成大顶堆。
		for (int i = (h.length - 2) / 2; i > -1; i--)
		{
			HeapAdjust(h, i, h.length - 1);
		}

		int tmp;
		for (int i = h.length - 1; i > 1; i--)
		{
			// 将堆顶记录 和 当前未经排序子序列Hr[i...i]中最后一个记录相互交换
			tmp = h[1];
			h[1] = h[i];
			h[i] = tmp;

			// 将H.r[1..r-1]重新调整为大顶堆
			HeapAdjust(h, 1, i - 1);
		}

	}

	private void HeapAdjust(int[] h, int s, int m)
	{
		// 已知r[s..m]中记录的关键字除r[s]之外均满足堆的定义。
		// 本函数调整r[s]的关键字，使r[s..m]成为一个大顶堆
		int rc = h[s];
		for (int j = 2 * s; j < m; j *= 2)// 沿key较大的孩子节点向下筛选
		{
			if (j < m && h[j] < h[j + 1])
				++j;// j为较大的记录的下标
			if (rc > h[j])
				break;/* rc应插入在位置s上 */
			h[s] = h[j];
			s = j;
		}
		h[s] = rc;/* 插入 */


	}

	public static void main(String[] args)
	{
		HeapSort sort = new HeapSort();
		int[] h = { 49, 38, 65, 97, 76, 13, 27, 49 };
		sort.heapSort(h);

		for (int k = 0; k < h.length; k++)
		{
			System.out.println(h[k]);
		}
	}
}
