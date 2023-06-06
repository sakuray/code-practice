package com.sakuray.code.practice.leetcode._1500_1599;

import java.util.Arrays;

/**
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
 * <p>
 * Input: arr = [3,5,1]
 * Output: true
 * Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 * <p>
 * Input: arr = [1,2,4]
 * Output: false
 * Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class _1502_CanMakeArithmeticProgressionFromSequence {

    /**
     * 排序，判断两数之差是不是一样
     * 注意：做+比-快，做-比×快，
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
