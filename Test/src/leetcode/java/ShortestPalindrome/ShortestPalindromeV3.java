package leetcode.java.ShortestPalindrome;

/**
 * 用Java暴力是可以过的，思路也很简单：
 * 
 * 补充完成之后的回文串中心必定在原字符串中，所以原字符串以第一个字符为起点必然存在至少一个回文串（长度可以为1），
 * 
 * 那么任务就变为找到原字符串中以第一个字符为起点最长的回文串，
 * 
 * 找到之后剩下的工作就是把剩余部分的翻转补充到原字符串头部即可。
 * 
 * 这样代码逻辑就很简单，就是从原字符串的头部开始截取子串，长度递减，直到获取到第一个是回文串的子串，
 * 
 * 此时就找到了需要截断的部分，从该位置开始到原字符串末尾就是需要截取并翻转拼接的部分。算法复杂度是O(n^2)。
 * 
 * 超时了！！！
 *
 */
public class ShortestPalindromeV3
{
	public String shortestPalindrome(String s)
	{
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		int len = s.length(), tail = len;

		StringBuilder builder = new StringBuilder();
		while (1 < tail)
		{
			if (isPalindrome(s.substring(0, tail)))
			{
				builder = builder.append(s.substring(tail, len)).reverse();
				break;
			}
			tail--;
		}
		if (builder.length() == 0)
		{
			builder = builder.append(s.substring(tail, len)).reverse();
		}
		return builder.append(s).toString();
	}

	private boolean isPalindrome(String str)
	{
		int len = str.length();
		for (int i = 0; i < len / 2; i++)
		{
			if (str.charAt(i) != str.charAt(len - i - 1))
				return false;
		}
		return true;
	}
}
