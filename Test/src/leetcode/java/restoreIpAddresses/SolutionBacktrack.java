package leetcode.java.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

public class SolutionBacktrack
{
	public List<String> restoreIpAddresses(String s)
	{
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0 || s.length() > 12)
		{
			return result;
		}
		StringBuilder builder = new StringBuilder();
		helper(result, s, builder, 0, 0);
		return result;
	}

	private void helper(List<String> result, String s, StringBuilder builder, int start, int count)
	{
		if (start == s.length() && count == 3)
		{
			result.add(builder.toString());
			return;
		}
		
		for (int i = start + 1; i <= s.length(); i++)
		{
			String tmp = s.substring(start, i);
			if (tmp.length() > 3 || tmp.length() > 1 && tmp.charAt(0) == '0' || Integer.parseInt(tmp) > 255)
			{
				return;
			}
			StringBuilder newBuilder = new StringBuilder(builder);
			if (newBuilder.length() != 0)
			{
				newBuilder.append(".");
			}
			newBuilder.append(tmp);
			helper(result, s, newBuilder, i, newBuilder.length() == tmp.length() ? count : count + 1);
		}
	}
}
