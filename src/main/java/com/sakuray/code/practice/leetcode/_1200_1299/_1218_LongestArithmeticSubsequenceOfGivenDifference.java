package com.sakuray.code.practice.leetcode._1200_1299;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr
 * which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [1,2,3,4].
 * <p>
 * Input: arr = [1,3,5,7], difference = 1
 * Output: 1
 * Explanation: The longest arithmetic subsequence is any single element.
 * <p>
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 */
public class _1218_LongestArithmeticSubsequenceOfGivenDifference {


    /**
     * 最长算数子序列，类似300题，该解法会超时
     */
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - difference == arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(j, res);
        }
        return res;
    }

    /**
     * 本质上从左往右不需要关注顺序，只需要知道上一个值累计了多少次
     */
    public int longestSubsequence_T(int[] arr, int d) {
        Map<Integer, Integer> mp = new HashMap<>();
        int mx = 0;
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i - d, 0) + 1);
            mx = Math.max(mp.get(i), mx);
        }
        return mx;
    }

    public int longestSubsequence_S(int[] arr, int diff) {
        int[] diffArr = new int[40001];
        int ans = 1;
        for (int i : arr) {
            diffArr[i + 20000] = diffArr[i - diff + 20000] + 1;
            ans = Math.max(ans, diffArr[i + 20000]);
        }
        return ans;
    }
}
