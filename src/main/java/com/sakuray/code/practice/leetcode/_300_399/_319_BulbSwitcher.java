package com.sakuray.code.practice.leetcode._300_399;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round,
 * you toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Return the number of bulbs that are on after n rounds.
 * <p>
 * Input: n = 3
 * Output: 1
 * Explanation: At first, the three bulbs are [off, off, off].
 * After the first round, the three bulbs are [on, on, on].
 * After the second round, the three bulbs are [on, off, on].
 * After the third round, the three bulbs are [on, off, off].
 * So you should return 1 because there is only one bulb is on.
 * <p>
 * Input: n = 0
 * Output: 0
 * <p>
 * Input: n = 1
 * Output: 1
 */
public class _319_BulbSwitcher {

    /**
     * 灯要亮着，一定要按奇数次
     * 第n盏灯被按地次数是：因式分解所有可能值的个数
     * 比如16 = 1 * 16 = 2 * 8 = 4 * 4 所以可能值是：1，2，4，8，16，被按5次
     * 为什么是平方根：思考一下完全平方和非完全平方的区别。如上面的16
     * n的因子一定是 a * b，成对出现，那么一定是偶数，如果灯要亮着，要按奇数次。
     * 什么情况下会出现奇数次：a = b，则只有完全平方数可以点亮灯。那么最后亮的就是n范围内有多少完全平方数。开方即可
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
