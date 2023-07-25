package com.sakuray.code.practice.leetcode.common;

/**
 * 二分法：
 * 简单来说就是移动左右两边下标，逼近得到结果。有点像数学里面的夹逼准则
 * 难点在于如何设计逼近，很多时候想不清楚怎么移动，这里通过几个例题来详细阐述各个细节
 */
public class Dichotomy {

    /**
     * 通用模版
     */
    public static int common(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            // 或者l <= r 根据左逼近，还是右逼近决定，大原则是所有的解都判断过，如果不需要判断可以跳过
            int m = l + (r - l) / 2;
            // 原则是逐步逼近，决定的那边，不能越过可能的值，不决定的满足条件还能跳过一位
            if (true) {
                l = m;
            } else {
                r = m;
            }
        }
        // 或者return r  根据左逼近，还是右逼近决定
        return l;
    }

    /**
     * 题目852，找山尖
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            // 为什么条件是arr[m] < arr[m+1]
            // 先观察m的取值，r - l是否可能 <= 1？ 当然可能，这会导致m = l，我们必须确保l推进，l = m + 1
            // 接下来就是满足什么条件，l = m + 1，一定要是上升趋势对吧。arr[m - 1] < arr[m] 不行吗？
            // 不行，这个时候只能说明l可以取m，m可能是山尖，不能越过。所以条件全部 + 1，变成arr[m] < arr[m+1]
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                // 为什么r = m，不是r = m - 1
                // 这个是根据前面的条件来的 arr[m] >= arr[m+1]，那么m是否可能是山尖？不能跳过m
                r = m;
            }
        }
        // 逼近条件是l < r，最终跳出通过就是l = r = m
        return l;
    }


    /**
     * 题目793：找阶乘产出K个零的N最大值
     */
    private long bound(int K) {
        // 如果有K个零，那么其右侧最大是5(k + 1)，这里面至少有k个5
        long l = 0, r = 5L * (K + 1);
        // 为什么是l <= r，主要在于我们的目标是逼近最大值，需要r
        while (l <= r) {
            long m = l + (r - l) / 2;
            long k = numOfTrailingZeros(m);
            if (k <= K) {
                // 这个条件意味着m满足条件，但不一定是最大的，由于我们关注的是右值，而左边也需要变化防止卡循环，所以m+1
                l = m + 1;
            } else {
                // 不满足意味着m比预期结果偏大，m-1才是可能的结果
                r = m - 1;
            }
        }
        return r;
    }

    long numOfTrailingZeros(long n) {
        long res = 0;
        for (; n > 0; n /= 5) {
            res += n / 5;
        }
        return res;
    }
}
