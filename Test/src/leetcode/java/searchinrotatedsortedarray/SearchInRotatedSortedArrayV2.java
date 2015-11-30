package leetcode.java.searchinrotatedsortedarray;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author wziyong 循环遍历，太挫了！！！！有规律的！！！
 * 
 * 超过7.04%
 */
public class SearchInRotatedSortedArrayV2
{

	public int search(int[] nums, int target)
	{
		if (null == nums)
		{
			return -1;
		}

		if (nums.length == 1 && nums[0] != target)
		{
			return -1;
		}

		if (nums.length == 1 && nums[0] == target)
		{
			return 0;
		}

		int head = 0;
		int tail = nums.length - 1;

		while (head <= tail)
		{
			if (target == nums[head])
			{
				return head;
			}
			else if (target == nums[tail])
			{
				return tail;
			}
			else
			{
				head++;
				tail--;
			}

		}

		return -1;
	}

	public static void main(String[] args)
	{

	}

}
