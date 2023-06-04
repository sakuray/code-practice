package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class _004_MedianOfTwoSortedArrays {

    /**
     * 如果num1 + num2是偶数个，需要找到：length / 2 和length / 2 + 1的数值
     * 如果num1 + num2是奇数个，需要找到：length + 1 / 2
     * 时间复杂度 只能是二分法，假设15个数字，需要找到第7个数字。那么7/2 = 3;，比较num1,num2第三个位置的数字，小的那个前三个一定不是
     * 剩下的就是num1[4,n] num2[0,m]，需要找到第7-3 = 4个数字，继续比较 num1第6个数字和num2的第2个数字
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
                + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }


    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int n = end1 - start1 + 1;
        int m = end2 - start2 + 1;
        if (n > m) {
            // 保障nums1短
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (n == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(n, k / 2) - 1;
        int j = start2 + Math.min(m, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
