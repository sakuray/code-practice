package com.sakuray.code.practice.leetcode._800_899;

import java.util.Arrays;

/**
 * Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.
 * Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
 * <p>
 * Input: piles = [5,3,4,5]
 * Output: true
 * Explanation:
 * Alice starts first, and can only take the first 5 or the last 5.
 * Say she takes the first 5, so that the row becomes [3, 4, 5].
 * If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
 * If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
 * <p>
 * Input: piles = [3,7,2,3]
 * Output: true
 */
public class _877_StoneGame {

    /**
     * 直接返回true就行，这里看dp解法
     * dp[i][j]表达式你能比对手多获取的数量，是在范围piles[i] ~ piles[j]中选择。只有2种选择piles[i]或者piles[j]
     * 选择piles[i]那么dp[i][j] = piles[i] - dp[i+1][j](对手能获取的最大)
     * 选择piles[j]那么dp[i][j] = piles[j] - dp[i][j-1](对手能获取的最大)
     * dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
     * <p>
     * 为什么一定能赢，条件有2个：偶数堆，石头数量是奇数
     * 这造成了一个问题，1，2，3，4堆，如果按下标区分奇数堆和偶数堆，1，3和2，4.那么必然有一组能赢
     * 而轮流选择又导致了一个问题：你一定能获取到奇数或者偶数堆，两边一定是一奇数堆，一偶数堆
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        // baseCase，仅有一堆，最大值就是它自己
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        // 可以发现存在路径压缩，只有斜对角线有值，迭代方向是右上角
        // 1 x x
        // x 2 x
        // x x 3
        // 需要填充右上角变成
        // 1 1 x
        // x 2 x
        // x x 3
        // 再次判断
        // 1 1 x
        // x 2 1
        // x x 3
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public boolean stoneGame_S(int[] piles) {
        int[] dp = Arrays.copyOf(piles, piles.length);
        for (int d = 1; d < piles.length; d++) {
            for (int i = 0; i < piles.length - d; i++) {
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[i + d] - dp[i]);
            }
        }
        return dp[0] > 0;
    }
}
