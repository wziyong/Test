package leetcode.java.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Runtime: 17 ms
 * 
 * @author wziyong
 *
 */
public class SurroundedRegionsBFS
{
	public void solve(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				// 四个边上，并且为O时
				if ((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && (board[i][j] == 'O'))
				{
					Queue<Integer> q = new LinkedList<Integer>();
					q.offer(i * board[0].length + j);

					// 标记为B
					board[i][j] = 'B';

					while (!q.isEmpty())
					{
						// 恢复坐标x和y
						Integer key = q.poll();
						int x = key / board[0].length;
						int y = key % board[0].length;

						// 坐标[x,y]上面节点为O
						if (x > 0 && board[x - 1][y] == 'O')
						{
							q.offer((x - 1) * board[0].length + y);
							board[x - 1][y] = 'B';
						}

						// 下
						if (x < board.length - 1 && board[x + 1][y] == 'O')
						{
							q.offer((x + 1) * board[0].length + y);
							board[x + 1][y] = 'B';
						}

						// 左
						if (y > 0 && board[x][y - 1] == 'O')
						{
							q.offer(x * board[0].length + y - 1);
							board[x][y - 1] = 'B';
						}

						// 右
						if (y < board[0].length - 1 && board[x][y + 1] == 'O')
						{
							q.offer(x * board[0].length + y + 1);
							board[x][y + 1] = 'B';
						}
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'B')
					board[i][j] = 'O';
			}
		}
	}
}
