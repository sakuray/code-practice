package com.sakuray.code.practice.leetcode;

import java.util.Arrays;

/**
 *Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
 *If there is no future day for which this is possible, put 0 instead.
  For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], 
  your output should be [1, 1, 4, 2, 1, 1, 0, 0].
  Note: The length of temperatures will be in the range [1, 30000]. 
  Each temperature will be an integer in the range [30, 100]. 
 */
public class _739_DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		for(int i = 0; i < temperatures.length; i++) {
			for(int j = i + 1; j < temperatures.length; j++) {
				if(temperatures[i] < temperatures[j]) {
					result[i] = j - i;
					break;
				}
			}
		}
        return result;
    }
	
	/**
	 * Let's process each i in reverse (decreasing order). At each T[i], to know when the next occurrence of say,
	 * temperature 100 is, we should just remember the last one we've seen, next[100].
	 * Then, the first occurrence of a warmer value occurs at warmer_index, 
	 * the minimum of next[T[i]+1], next[T[i]+2], ..., next[100].
	 */
	public int[] dailyTemperatures_S(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }
}
