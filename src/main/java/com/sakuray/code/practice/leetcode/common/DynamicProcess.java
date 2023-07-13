package com.sakuray.code.practice.leetcode.common;

import java.util.Arrays;

/**
 * https://labuladong.github.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-1e688/
 * 动态规划:关键在于确定转换公式。一般都是求N，其是由前面0-N-1的结果确认，通用的步骤：
 * 1.明确自己要求的N是什么
 * 2.明确N如何从(0,N-1)的结果得到，状态转换公式，本质上就是数学归纳法
 * 3.明确初始值，数学归纳法的a0的值，在动态规划中不一定只是a0能确定初始值，文章里面的bad case
 * 上面很好理解，其实遇到动态规划问题，最难的是如何判断其可以使用动态规划，数学归纳法很好理解，但是在实际应用中得能看出来
 * 以几个特色的运算来举例说明：
 * 1.斐波那契数列 509
 * 2.凑硬币  322
 */
public class DynamicProcess {


    /**
     * 斐波那契数列，本质就是数学归纳法
     * 1.求x=n时，f(x)的结果
     * 2.f(x) = f(x-1) + f(x-2)
     * 3.初始值f(0) = 0, f(1) = 1
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        // base case
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int tmp = b;
            // 状态转换公式
            b = a + b;
            a = tmp;
        }
        return b;
    }

    /**
     * 凑硬币，计算凑到amount需要的最少银币数量，币的面额coins
     * 1.求的函数是f(amount) = 最少银币数量
     * 2.状态转换公式是：f(amount) = min (f(amount - coins)) + 1
     * 3.迭代的初始值是:f(0) = 0
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 状态转换公式，从i -coin 得到最小结果+1
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
