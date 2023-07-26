package com.sakuray.code.practice.leetcode._1800_1899;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * You are given a floating-point number hour, representing the amount of time you have to reach the office.
 * To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n,
 * where dist[i] describes the distance (in kilometers) of the ith train ride.
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 * For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.
 * Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal
 * <p>
 * Input: dist = [1,3,2], hour = 6
 * Output: 1
 * Explanation: At speed 1:
 * - The first train ride takes 1/1 = 1 hour.
 * - Since we are already at an integer hour, we depart immediately at the 1 hour mark. The second train takes 3/1 = 3 hours.
 * - Since we are already at an integer hour, we depart immediately at the 4 hour mark. The third train takes 2/1 = 2 hours.
 * - You will arrive at exactly the 6 hour mark.
 * <p>
 * Input: dist = [1,3,2], hour = 2.7
 * Output: 3
 * Explanation: At speed 3:
 * - The first train ride takes 1/3 = 0.33333 hours.
 * - Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
 * - Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
 * - You will arrive at the 2.66667 hour mark.
 * <p>
 * Input: dist = [1,3,2], hour = 1.9
 * Output: -1
 * Explanation: It is impossible because the earliest the third train can depart is at the 2 hour mark.
 */
public class _1870_MinimumSpeedToArriveOnTime {

    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 6));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
        System.out.println(minSpeedOnTime(new int[]{1,1,100000}, 2.01));
        System.out.println(minSpeedOnTime(new int[]{1,1,100000}, 3.01));
        System.out.println(minSpeedOnTime(new int[] {69}, 4.6));
    }


    /**
     * 需要在hour内到达，给出每段路的距离，非最后一段路，前面耗时需要向上取整。
     * 比如0.1hour，需要计算成1hour，求最慢速度，不行返回-1.
     * 先看什么情况下不行？由于向上取整，所以每段最少是1小时，最后一段可以是小数。
     * 所以dist.length - 1 < hour
     * 假设速度是x，dist[i] / x 向上取整 + dist[end] / x <= hour
     * 如果全部1小时 > hour，说明前面必须在1小时内，最后需要小于hour的小数
     * 最后一种情况就是hour非常富足，那么最小速度取决于充分利用hour，简单来说，每段的实际速度比较均匀
     * 如何理解均匀：
     * 1，3，2总共距离是6，hour是6，理想均匀速度是1，是否满足？可以满足。
     * 不满足的情况是什么？Math.ceil(dist[i]/x)花了更多的时间，
     * 所以hour/distinct这个速度是最低可能速度，实际每段速度导致耗时可能 + 1，最后一段不需要
     * 最高的可能速度是多少？假设每段耗时为1小时，一定是在hour内完成，最大速度就是每段的距离
     */
    public static int minSpeedOnTime(int[] dist, double hour) {
        int len = dist.length;
        if (len - 1 >= hour) {
            return -1;
        }
        if (len > hour) {
            int min = 0;
            for (int i = 0; i < len - 2; i++) {
                min = Math.max(min, dist[i]);
            }
            BigDecimal subtract = BigDecimal.valueOf(hour).add(new BigDecimal(1)).subtract(new BigDecimal(len));
            int lastMin = new BigDecimal(dist[len - 1]).divide(subtract, RoundingMode.UP).intValue();
            return Math.max(min, lastMin);
        } else {
            int minDistinct = 0, r = 0;
            for (int j : dist) {
                r = Math.max(j, r);
                minDistinct += j;
            }
            int l = (int) Math.floor(minDistinct / hour);
            int m;
            int ans = -1;
            while (l <= r) {
                m = (l + r) / 2;
                if (check(dist, hour, m)) {
                    ans = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return ans;
        }
    }

    public static boolean check(int[] dist, double hour, double speed) {
        double time = 0;
        int i = 0;
        while (time <= hour && i < dist.length - 1) {
            time += Math.ceil(dist[i] / speed);
            i++;
        }
        time += dist[dist.length - 1] / speed;
        return (time <= hour);
    }
}
