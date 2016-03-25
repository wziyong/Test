package sort;

public class 快速排序
{
	public int partition(int[] A, int left, int right)
	{
		int x = A[left];// 第一个元素为分隔点
		int i = left, j = right;
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

	public void quickSort(int[] A, int left, int right)
	{
		if (left < right)
		{
			int i = partition(A, left, right);
			quickSort(A, left, i - 1);
			quickSort(A, i + 1, right);
		}
	}

	public static void main(String[] args)
	{
		快速排序 sort = new 快速排序();

		int[] A = { 2, 5, 9, 8, 7, 1, 10 };
		sort.quickSort(A, 0, A.length - 1);
	}

}
