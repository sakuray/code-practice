package com.sakuray.code.practice.leetcode._300_399;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Input: a = 2, b = [3]
 * Output: 8
 * <p>
 * Input: a = 2, b = [1,0]
 * Output: 1024
 * <p>
 * Input: a = 1, b = [4,3,3,8,5,2]
 * Output: 1
 */
public class _372_SuperPow {

    public static void main(String[] args) {
        System.out.println(8 == superPow(2, new int[]{3}));
        System.out.println(1184 == superPow(1931497, new int[]{2, 3, 5, 8, 0, 0, 1, 8, 6, 4, 4, 7, 1, 9, 0, 9, 8, 3, 1, 8, 0,
                1, 6, 2, 3, 4, 8, 7, 0, 5, 4, 0, 8, 9, 0, 1, 1, 3, 9, 0, 0, 5, 7, 1, 5, 9, 0, 5, 3, 4, 3, 3, 5, 2, 7, 0,
                8, 5, 7, 8, 1, 3, 0, 1, 5, 2, 2, 6, 6, 3, 6, 6, 9, 6, 9, 6, 5, 1, 3, 8, 5, 6, 4, 1, 0, 1, 3, 0, 9, 1, 9,
                0, 6, 1, 3, 1, 4, 6, 0, 2, 1, 8, 0, 2, 4, 9, 8, 0, 2, 1, 0, 8, 0, 4, 1, 2, 8, 4, 3, 7, 7, 4, 9, 4, 5, 2,
                5, 1, 0, 5, 5, 2, 4, 5, 4, 0, 6, 5, 2, 9, 8, 3, 9, 0, 9, 0, 3, 9, 6, 8, 8, 4, 4, 7, 0, 9, 2, 5, 3, 2, 3,
                8, 6, 9, 6, 3, 9, 2, 8, 4, 3, 8, 7, 2, 9, 8, 4, 4, 0, 3, 4, 8, 9, 8, 6, 9, 9, 8, 6, 2, 2, 1, 3, 9, 0, 9,
                2, 2, 3, 2, 6, 7, 0, 5, 1, 1, 3, 6, 7, 3, 9, 1, 4, 8, 1, 0, 9, 1, 0, 5, 5, 2, 7, 0, 1, 9, 9, 5, 1, 5, 7,
                7, 2, 0, 4, 5, 1, 0, 3, 9, 5, 2, 2, 9, 2, 4, 9, 3, 5, 9, 9, 2, 4, 8, 3, 7, 7, 4, 3, 9, 9, 2, 8, 3, 2, 3,
                9, 6, 3, 2, 7, 8, 7, 9, 8, 1, 5, 9, 5, 2, 1, 6, 5, 5, 4, 8, 2, 1, 4, 7, 2, 4, 0, 1, 7, 4, 6, 8, 0, 1, 3,
                7, 1, 0, 9, 1, 3, 4, 1, 8, 7, 4, 4, 4, 9, 0, 4, 3, 2, 8, 1, 6, 2, 3, 9, 2, 7, 5, 2, 8, 8, 5, 7, 0, 5, 8,
                1, 9, 5, 4, 9, 4, 8, 6, 8, 9, 6, 2, 5, 0, 0, 6, 7, 5, 1, 6, 9, 8, 4, 1, 8, 2, 7, 8, 4, 2, 8, 8, 3, 3, 2,
                3, 7, 3, 9, 7, 2, 7, 1, 7, 8, 4, 5, 7, 9, 8, 5, 0, 7, 1, 1, 7, 6, 8, 5, 0, 3, 6, 8, 6, 9, 3, 1, 9, 6, 2,
                8, 8, 2, 0, 8, 0, 4, 5, 9, 5, 4, 4, 5, 3, 6, 8, 0, 2, 7, 8, 4, 0, 4, 3, 8, 5, 6, 2, 6, 2, 6, 5, 2, 8, 7,
                2, 0, 3, 8, 9, 0, 4, 6, 7, 7, 4, 5, 9, 6, 2, 7, 2, 4, 3, 5, 5, 9, 3, 9, 7, 7, 5, 2, 2, 6, 1, 4, 6, 4, 4,
                8, 6, 8, 4, 3, 5, 8, 9, 5, 6, 1, 4, 8, 8, 8, 6, 5, 9, 9, 4, 8, 7, 1, 1, 9, 7, 4, 5, 4, 1, 0, 4, 7, 0, 8,
                1, 8, 8, 0, 5, 4, 3, 9, 2, 1, 9, 8, 6, 0, 0, 2, 9, 9, 4, 2, 0, 1, 8, 5, 7, 9, 7, 3, 7, 8, 1, 8, 8, 9, 0,
                3, 5, 3, 4, 8, 7, 6, 8, 5, 6, 8, 8, 7, 7, 2, 1, 9, 5, 0, 5, 5, 9, 4, 8, 6, 2, 2, 6, 0, 3, 6, 5, 9, 0, 0,
                7, 7, 6, 7, 4, 4, 8, 2, 2, 7, 6, 3, 7, 4, 3, 2, 1, 5, 6, 1, 1, 1, 3, 8, 3, 7, 6, 9, 6, 6, 1, 5, 5, 7, 2,
                0, 1, 0, 4, 5, 8, 1, 1, 5, 7, 4, 9, 8, 1, 7, 9, 3, 8, 5, 3, 2, 2, 9, 3, 0, 8, 4, 5, 3, 3, 9, 5, 4, 2, 2,
                2, 2, 3, 3, 9, 2, 9, 8, 0, 1, 7, 1, 4, 6, 6, 9, 0, 8, 8, 5, 0, 8, 9, 5, 4, 2, 7, 9, 8, 9, 1, 0, 3, 6, 3,
                2, 8, 5, 2, 0, 6, 9, 2, 2, 5, 8, 1, 7, 9, 1, 2, 9, 0, 3, 7, 4, 7, 6, 5, 6, 5, 9, 8, 0, 5, 4, 2, 6, 9, 4,
                8, 5, 3, 0, 9, 1, 1, 0, 0, 2, 3, 5, 3, 5, 8, 2, 9, 8, 8, 7, 4, 5, 6, 2, 5, 3, 8, 7, 9, 7, 3, 0, 4, 9, 0,
                3, 2, 3, 5, 2, 7, 9, 7, 1, 4, 8, 5, 6, 6, 4, 3, 2, 1, 9, 6, 7, 4, 5, 6, 6, 2, 0, 6, 7, 1, 8, 2, 3, 2, 8,
                5, 9, 7, 5, 2, 3, 5, 8, 1, 3, 4, 4, 5, 5, 5, 3, 4, 0, 8, 1, 6, 3, 3, 4, 2, 4, 2, 4, 9, 4, 2, 6, 6, 1, 1,
                0, 7, 8, 0, 8, 1, 4, 3, 8, 0, 0, 4, 6, 2, 2, 7, 0, 7, 2, 4, 9, 8, 7, 4, 7, 3, 6, 4, 1, 0, 7, 4, 7, 8, 4,
                5, 9, 9, 0, 0, 1, 3, 4, 7, 5, 8, 5, 8, 6, 9, 2, 5, 8, 1, 1, 7, 7, 8, 3, 0, 0, 1, 4, 7, 9, 9, 4, 0, 8, 7,
                2, 9, 0, 8, 6, 7, 7, 3, 5, 5, 5, 8, 2, 3, 1, 4, 2, 0, 4, 6, 1, 4, 7, 5, 3, 8, 4, 7, 0, 2, 4, 3, 3, 6, 1,
                2, 4, 0, 5, 9, 7, 0, 9, 0, 5, 3, 4, 8, 3, 0, 4, 4, 4, 3, 0, 9, 3, 4, 6, 3, 9, 3, 6, 2, 9, 0, 4, 5, 0, 2,
                5, 8, 4, 6, 0, 2, 9, 6, 0, 3, 6, 6, 9, 2, 1, 9, 1, 4, 6, 9, 7, 5, 4, 6, 9, 6, 6, 6, 1, 6, 8, 8, 6, 4, 5}));
    }

    /**
     * 难点：
     * 如何处理幂数数组进行运算：a ^ 1234 = a ^ 4 * a ^ 1230 = a ^ 4 * (a ^ 123) ^ 10，递归处理
     * pow溢出，怎么取模：(a * b) % k = (a % k) * (b % k) % k
     * a = Ak + B；b = Ck + D =》ab = ACk^2 + ADk + BCk +BD =》 ab %  k = BD % k =》 (a % k) * (b % k) % k
     * 如何快速得到幂结果
     */
    public static int superPow(int a, int[] b) {
        if (b == null || b.length == 0) {
            return 1;
        }
        return superPow2(a, b, b.length - 1);
    }

    private static int superPow2(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        int cur = pow(a, b[index]);
        int next = pow(superPow2(a, b, index - 1), 10);
        return (cur * next) % 1337;
    }

    private static int pow(int a, int k) {
        if (k == 0 || a == 1) {
            return 1;
        }
        a = a % 1337;
        if (k % 2 == 1) {
            return (a * pow(a, k - 1)) % 1337;
        } else {
            int result = pow(a, k / 2);
            return (result * result) % 1337;
        }
    }
}
