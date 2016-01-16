package leetcode.java.populatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_my
{
	public void connect(TreeLinkNode root)
	{
		if (null == root)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		TreeLinkNode tmp = null;
		TreeLinkNode next = null;

		while (!queue.isEmpty())
		{
			int levelNum = queue.size();
			for (int i = 1; i <= levelNum; i++)
			{
				if (i == 1)
				{
					// 每层最右侧为null
					tmp = queue.poll();
					tmp.next = null;
				}
				else
				{
					tmp = queue.poll();
					tmp.next = next;
				}

				next = tmp;

				if (null != tmp.right)
					queue.offer(tmp.right);
				if (null != tmp.left)
					queue.offer(tmp.left);
			}
		}

	}
}

class TreeLinkNode
{
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x)
	{
		val = x;
	}
}
