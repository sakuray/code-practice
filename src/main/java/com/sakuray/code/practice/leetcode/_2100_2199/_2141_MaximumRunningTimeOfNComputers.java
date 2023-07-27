package com.sakuray.code.practice.leetcode._2100_2199;

/**
 * You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run a computer for batteries[i] minutes.
 * You are interested in running all n computers simultaneously using the given batteries.
 * Initially, you can insert at most one battery into each computer. After that and at any integer time moment,
 * you can remove a battery from a computer and insert another battery any number of times.
 * The inserted battery can be a totally new battery or a battery from another computer.
 * You may assume that the removing and inserting processes take no time.
 * Note that the batteries cannot be recharged.
 * Return the maximum number of minutes you can run all the n computers simultaneously.
 * <p>
 * Input: n = 2, batteries = [3,3,3]
 * Output: 4
 * Explanation:
 * Initially, insert battery 0 into the first computer and battery 1 into the second computer.
 * After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1 can still run for one minute.
 * At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert battery 1 instead.
 * By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
 * We can run the two computers simultaneously for at most 4 minutes, so we return 4.
 * <p>
 * Input: n = 2, batteries = [1,1,1,1]
 * Output: 2
 * Explanation:
 * Initially, insert battery 0 into the first computer and battery 2 into the second computer.
 * After one minute, battery 0 and battery 2 are drained so you need to remove them and insert battery 1 into the first computer and battery 3 into the second computer.
 * After another minute, battery 1 and battery 3 are also drained so the first and second computers are no longer running.
 * We can run the two computers simultaneously for at most 2 minutes, so we return 2.
 */
public class _2141_MaximumRunningTimeOfNComputers {

    /**
     * 有N台电脑，arr.length块电池，每块电池可以让电脑工作arr[i]分钟。可以任意插拔电池，求最长让所有电脑同时工作的时长
     * 首先：Math.floor(sum(arr) / n)是上界，不可能超过这个值，其次可能低于这个值，在于如何组合充分利用的问题
     * 比如 2台电脑  3块电池   1，1，1000  1002/3 = 334,但实际上只能2分钟，从这个例子可以看出如何思考这个问题？
     * 先消耗使用寿命最长的N快电池1分钟，再消耗当前使用寿命最长的。。最后如果可用电池不足N，就是最大的。如何用代码实现？
     * 优先队列 与 暴力 - 1？换个思路：最少是1，最大是上面说的上界，结果一定是[1,Math.floor(sum / n)]之中。是不是可以用二分查找？
     * 需要解决的问题是，如何逼近？假设选择消耗x，那么n台电脑就要消耗nx。再看电池，每个电池都要消耗x，不足就是电池本身电量。
     * 这是电池能提供的最大时长，如果这个时长超过nx，那么x一定满足。如果比这个小。说明大部分电池都被耗尽了。剩余电池不足n块。无法满足。
     * 还是上面例子：[1,334]，x=3，需要6电量。但是min(1,3) + min(1,3) + min(1000,3) = 5不够6电量。剩下的电池肯定是无法满足n的。
     * 113可以自由组合，x无法到3
     */
    public long maxRunTime(int n, int[] batteries) {
        long l = 1, r = 0;
        for (int b : batteries) {
            r += b;
        }
        r = r / n;
        while (l < r) {
            long m = (l + r + 1) / 2;
            long time = 0;
            for (int b : batteries) {
                time += Math.min(b, m);
            }
            if (time >= n * m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
