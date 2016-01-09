package leetcode.java.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 33 / 33 test cases passed.
 * 
 * Status: Accepted
 * 
 * Runtime: 4 ms
 *
 * 两个堆栈，不断地翻转；
 */
public class BinaryTreeZigzagLevelOrderTraversal_my
{
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (null == root)
		{
			return result;
		}

		Stack<TreeNode> stack_left = new Stack<TreeNode>();// 从左到右
		Stack<TreeNode> stack_right = new Stack<TreeNode>();// 从右到左

		stack_left.push(root);

		boolean direction = true;// True 为从左到右
		List<Integer> tmp = new ArrayList<Integer>();
		TreeNode x = null;
		while (!stack_left.isEmpty() || !stack_right.isEmpty())
		{
			if (direction) // 从左到右
			{
				x = stack_left.pop();
				tmp.add(x.val);
				if (null != x.left)
					stack_right.push(x.left);
				if (null != x.right)
					stack_right.push(x.right);

				if (stack_left.isEmpty()) // 如果已经空了
				{
					result.add(tmp);
					tmp = new ArrayList<Integer>();
					direction = !direction;
				}

			}
			else// 从右到左
			{
				x = stack_right.pop();
				tmp.add(x.val);
				if (null != x.right)
					stack_left.push(x.right);
				if (null != x.left)
					stack_left.push(x.left);

				if (stack_right.isEmpty()) // 如果已经空了
				{
					result.add(tmp);
					tmp = new ArrayList<Integer>();
					direction = !direction;
				}
			}

		}

		return result;
	}

	public static void main(String[] args)
	{
		TreeNode x1 = new TreeNode(1);
		TreeNode x2 = new TreeNode(2);
		TreeNode x3 = new TreeNode(3);
		TreeNode x4 = new TreeNode(4);
		x1.left = x2;
		x1.right = x3;
		x2.left = x4;
		BinaryTreeZigzagLevelOrderTraversal_my.zigzagLevelOrder(x1);

	}

}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		this.val = x;
	}
}
