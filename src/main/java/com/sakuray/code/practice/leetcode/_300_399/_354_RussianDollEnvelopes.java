package com.sakuray.code.practice.leetcode._300_399;

import java.util.Arrays;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * Note: You cannot rotate an envelope.
 * <p>
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * <p>
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 */
public class _354_RussianDollEnvelopes {

    /**
     * 见题300，从一维转换成二维，剩下的就是如何从二维降到一维。
     * 简单来说就是w升序，保证后面可以套前面，同级再降序，这样确保找最大子序列的时候同级不会被包含
     * 下列会超时，只能使用二分查找
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }


    /**
     * patience game
     * patience sorting
     * https://labuladong.github.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-6ea57/#%E4%BA%8C%E3%80%81%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E8%A7%A3%E6%B3%95
     */
    public int maxEnvelopes_S(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] envelope : envelopes) {
            int val = envelope[1];
            int insertIndex = binarySearch(dp, val);
            ans = Math.max(ans, insertIndex);
            if (dp[insertIndex] >= val) {
                dp[insertIndex] = val;
            }
        }
        return ans;
    }

    public int binarySearch(int[] dp, int val) {
        int lo = 0, hi = dp.length - 1, res = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (dp[mid] < val) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res + 1;
    }
}
