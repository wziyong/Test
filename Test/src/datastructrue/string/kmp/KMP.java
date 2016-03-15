package datastructrue.string.kmp;

public class KMP
{
	// 成功了
	public static void GetNext(String s)
	{
		int[] next = new int[s.length()];
		int pLen = s.length();
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < pLen - 1)
		{
			// p[k]表示前缀，p[j]表示后缀
			if (k == -1 || s.charAt(j) == s.charAt(k))
			{
				++k;
				++j;
				next[j] = k;
			}
			else
			{
				k = next[k];
			}
		}
	}

	public static void main(String[] args)
	{
		GetNext("DABCDABDE");

	}
}
