package com.sakuray.code.practice.leetcode._400_499;

import java.util.Arrays;

/**
 * You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
 * Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0.
 * At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1])
 * which reduces the size of the array by 1. The player adds the chosen number to their score.
 * The game ends when there are no more elements in the array.
 * Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner,
 * and you should also return true. You may assume that both players are playing optimally.
 * <p>
 * Input: nums = [1,5,2]
 * Output: false
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return false.
 * <p>
 * Input: nums = [1,5,233,7]
 * Output: true
 * Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose,player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 */
public class _486_PredictTheWinner {

    /**
     * 类似877，动态规划
     * dp[i][j]表明在i-j范围内你能比对手更多的数量，只能选nums[i]和nums[j]
     * dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
     * 初始状态，就是最后只剩一堆的情况. dp[i][i] = nums[i]
     * 观察状态转移的公式：当前 x的值，取决于左上，以及下方的值，即
     * y1 x
     * *  y2
     * 初始状态只有↘这条线，那么迭代周期一定是沿着这条线平移↘↘↘这种。
     * 我们的目标就是判断dp[i][nums.lenght -1]是否>=0
     * 右下移动进行迭代。i需要反复回到0，所以横坐标的变化在内层。j从第一批开始横向移动即可，设置成d
     * 能遍历的i和d的数值相关 n - d
     * for (int d = 1; d < n; d++) {
     * *  for (int i = 0; i < n - d; i++) {
     * *     dp[i][i + d] = Math.max(nums[i] - dp[i + 1][i + d], nums[i + d] - dp[i][i + d - 1]);
     * *  }
     * }
     * 观察上面例子，存在路径压缩，i+d 和 i+d-1，只关注前值。可以移除
     * dp[i] = Math.max(nums[i] - dp[i+1], nums[i + d] - dp[i]);
     */
    public boolean PredictTheWinner(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int d = 1; d < nums.length; d++) {
            for (int i = 0; i < nums.length - d; i++) {
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[i + d] - dp[i]);
            }
        }
        return dp[0] >= 0;
    }
}
