package com.sakuray.code.practice.leetcode._700_799;

/**
 * Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3 * ... * x and by convention, 0! = 1.
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has two zeroes at the end.
 * Given an integer k, return the number of non-negative integers x have the property that f(x) = k.
 * <p>
 * Input: k = 0
 * Output: 5
 * Explanation: 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
 * <p>
 * Input: k = 5
 * Output: 0
 * Explanation: There is no x such that x! ends in k = 5 zeroes.
 * <p>
 * Input: k = 3
 * Output: 5
 */
public class _793_PreimageSizeOfFactorialZeroesFunction {

    /**
     * 找到产出k个尾缀0的阶乘有多少个
     * 1.阶乘N越大0越多，见172，本质是有多少个5
     * 2.本质上是找产出K个零的最大和最小的N值，两者相减 + 1就是最后结果
     */
    public int preimageSizeFZF(int k) {
        // 找右边界，两者一减就是范围(]
        return (int)(bound(k) - bound(k - 1));
    }

    private long bound(int K) {
        // 如果有K个零，那么其右侧最大是5(k + 1)，这里面至少有k个5
        long l = 0, r =  5L * (K + 1);
        while (l <= r) {
            long m = l + (r - l) / 2;
            long k = numOfTrailingZeros(m);
            if (k <= K) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    long numOfTrailingZeros(long n) {
        long res = 0;
        for (; n > 0; n /= 5) {
            res += n/5;
        }
        return res;
    }
}
