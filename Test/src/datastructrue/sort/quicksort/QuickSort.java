package datastructrue.sort.quicksort;

public class QuickSort
{
	public int partition(int[] A, int l, int r)
	{
		int x = A[l];// 第一个元素为分隔点
		int i = l, j = r;
		while (i < j)
		{
			// 从右向左找小于x的书来填A[i]
			while (i < j && A[j] >= x)
				j--;
			if (i < j)
			{
				A[i] = A[j];// 将s[j]填到s[i]中，s[j]就形成了一个新的坑
				i++;
			}

			// 从左向右找大于x的数来填充A[j]
			while (i < j && A[i] <= x)
				i++;
			if (i < j)
			{
				A[j] = A[i];// 将s[i]填到s[j]中，s[i]就形成了一个新的坑
				j--;
			}
		}
		// 退出时，i=j。将X填充到这个坑中。
		A[i] = x;

		return i;
	}

	public void quickSort(int[] A, int l, int r)
	{
		if (l < r)
		{
			int i = partition(A, l, r);
			quickSort(A, l, i - 1);
			quickSort(A, i + 1, r);
		}
	}

	public static void main(String[] args)
	{
		QuickSort sort = new QuickSort();

		int[] A = { 2, 5, 9, 8, 7, 1, 10 };
		sort.quickSort(A, 0, A.length - 1);
	}

}
