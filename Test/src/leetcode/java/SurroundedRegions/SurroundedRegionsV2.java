package leetcode.java.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路：从边上的O开始便利，所有与边上O相连的O都不能变成X（可暂时变为Y），之后再重新遍历一遍矩阵把所有O变成X，所有Y变成O。
 * 
 * 需要注意的是，本题使用DFS也会出现栈溢出，只能使用BFS。从队列中取出一个节点，把该节点变为Y，如果该节点的四周有还未变为Y的O，则这些节点放入队列。
 * 
 * @author wziyong
 *
 */
public class SurroundedRegionsV2
{

	public void solve(char[][] board)
	{
		if (board == null || board.length == 0)
		{
			return;
		}
		
		Queue<Pair> queue = new LinkedList<Pair>();
		
		// 对所有在边上的O节点进行BFS
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (i == 0 || i == (board.length - 1) || j == 0 || j == (board[0].length - 1))
				{
					if (board[i][j] == 'O')
					{
						Pair position = new Pair(i, j);
						queue.add(position);
					}
				}
			}
		}
		int x1, y1;
		// BFS
		while (!queue.isEmpty())
		{
			Pair position = (Pair) queue.poll();
			x1 = position.x;
			y1 = position.y;

			if (board[x1][y1] == 'Y')
			{
				continue;
			}
			// 四个方向查找，找到为'O'的节点放入队列中。
			// left
			board[x1][y1] = 'Y';
			int index = x1 - 1;
			if (index >= 0 && board[index][y1] == 'O')
			{
				queue.add(new Pair(index, y1));
			}
			// right
			index = x1 + 1;
			if (index < board.length && board[index][y1] == 'O')
			{
				queue.add(new Pair(index, y1));
			}
			// up
			index = y1 + 1;
			if (index < board[0].length && board[x1][index] == 'O')
			{
				queue.add(new Pair(x1, index));
			}
			// down
			index = y1 - 1;
			if (index >= 0 && board[x1][index] == 'O')
			{
				queue.add(new Pair(x1, index));
			}
		}

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 'Y')
				{
					board[i][j] = 'O';
				}
				else
				{
					if (board[i][j] == 'O')
					{
						board[i][j] = 'X';
					}
				}
			}
		}
		return;
	}
}

class Pair
{
	int x;
	int y;

	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
