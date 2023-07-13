package com.sakuray.code.practice.leetcode._300_399;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class _322_CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1,2,5}, 100));
    }

    /**
     * 凑银币，最少的步骤凑出银币
     * dp[n] = min{dp[n - coin[i]]} + 1
     * 金额0，只需要0凑出来
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
