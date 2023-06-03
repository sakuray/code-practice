package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class _088_MergeSortedArray {


    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,4,0,0,0};
        merge(num1, 4, new int[]{2,2,3}, 3);
        PrintTools.printArray(num1);
        num1 = new int[]{1,2,3,0,0,0};
        merge(num1, 3, new int[]{2,5,6}, 3);
        PrintTools.printArray(num1);
        num1 = new int[]{0};
        merge(num1, 0, new int[]{1}, 1);
        PrintTools.printArray(num1);
        num1 = new int[]{0,0,0};
        merge(num1, 0, new int[]{1,2,3}, 3);
        PrintTools.printArray(num1);
        num1 = new int[]{1,2,3,0};
        merge(num1, 3, new int[]{1,0,0}, 1);
        PrintTools.printArray(num1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int endIndex = m + n - 1;
        int num1End = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (num1End < 0) {
                nums1[endIndex] = nums2[i];
            } else if (nums2[i] >= nums1[num1End]) {
                nums1[endIndex] = nums2[i];
            } else {
                nums1[endIndex] = nums1[num1End];
                i = i + 1;
                num1End--;
            }
            endIndex--;
        }
    }
}
