package leetcode.java.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeLevelOrderTraversal_my
{
	public static List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (null == root)
		{
			return result;
		}

		Queue<TreeNode> queue_left = new LinkedList<TreeNode>();// 从左到右
		Queue<TreeNode> queue_right = new LinkedList<TreeNode>();// 从右到左

		queue_left.add(root);

		boolean direction = true;// True 为从左到右
		List<Integer> tmp = new ArrayList<Integer>();
		TreeNode x = null;
		while (!queue_left.isEmpty() || !queue_right.isEmpty())
		{
			if (direction) // 从左到右
			{
				x = queue_left.poll();
				tmp.add(x.val);
				if (null != x.left)
					queue_right.add(x.left);
				if (null != x.right)
					queue_right.add(x.right);

				if (queue_left.isEmpty()) // 如果已经空了
				{
					result.add(tmp);
					tmp = new ArrayList<Integer>();
					direction = !direction;
				}

			}
			else// 从右到左
			{
				x = queue_right.poll();
				tmp.add(x.val);
				if (null != x.left)
					queue_left.add(x.left);
				if (null != x.right)
					queue_left.add(x.right);

				if (queue_right.isEmpty()) // 如果已经空了
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
		BinaryTreeLevelOrderTraversal_my.levelOrder(x1);

	}

}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x)
	{
		this.val = x;
	}
}
