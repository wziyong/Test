package leetcode.java.trappingrainwater;

public class Solution4
{
	public static int trap(int[] height)
	{
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right)
		{
 			if (height[left] <= height[right])
			{
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];
				left++;
			}
			else
			{
				secHight = Math.max(height[right], secHight);
				area += secHight - height[right];
				right--;
			}
		}
		return area;
	}

	public static void main(String[] args)
	{
		int[] xx = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(xx));
	}
}
