package leetcode.java.searchinrotatedsortedarray;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author wziyong
 * 循环遍历，太挫了！！！！有规律的！！！
 * 
 * 打败了7.9%的人
 */
public class SearchInRotatedSortedArrayV1
{

	public int search(int[] nums, int target)
	{
		if (null == nums)
		{
			return -1;
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (target == nums[i])
			{
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{

	}

}
