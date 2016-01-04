package leetcode.java.SortColors;

/**
 * 从数组两端向中间遍历，前面放0，后面放2,。把前面出现的2放到后面，后面出现的0放到前面，这样中间剩下的就是1。
 * 
 * 用i一个指针遍历数组，r, b两个变量记录当前出现0和2的个数，也即放0和2的位置指针。
 * 
 * 捯饬来，捯饬去
 * 
 * @author wziyong
 *
 */
public class SortColurs
{
	public void swap(int[] A, int a, int b)
	{
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}

	public void sortColors(int[] A)
	{
		int len = A.length;
		int i, r = 0, b = 0;
		for (i = 0; i < len - b; i++)
		{
			if (A[i] == 0)
			{
				swap(A, i, r);
				r++;
			}
			else if (A[i] == 2)
			{
				swap(A, i, len - 1 - b);
				b++;
				i--; // 后面交换过来的元素也要进行判断
			}
		}
	}

	public static void main(String[] args)
	{
		int[] x = { 0, 2, 1, 2, 0 };
		SortColurs s = new SortColurs();
		s.sortColors(x);

	}

}
