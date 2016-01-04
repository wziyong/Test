package leetcode.java.Subsets.I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        sort (S.begin(), S.end());
        int elem_num = S.size();
        int subset_num = pow (2, elem_num);
        vector<vector<int> > subset_set (subset_num, vector<int>());
        for (int i = 0; i < elem_num; i++)
            for (int j = 0; j < subset_num; j++)
                if ((j >> i) & 1)
                    subset_set[j].push_back (S[i]);
        return subset_set;
    }
};
 * @author wziyong
 *
 */
public class SubsetsIBitManipulation
{
	public List<List<Integer>> subsets(int[] S)
	{
		Arrays.sort(S);
		int totalNumber = 1 << S.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
		for (int i = 0; i < totalNumber; i++)
		{
			List<Integer> set = new LinkedList<Integer>();
			for (int j = 0; j < S.length; j++)
			{
				if ((i & (1 << j)) != 0)
				{
					set.add(S[j]);
				}
			}
			collection.add(set);
		}
		return collection;
	}

}
