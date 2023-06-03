package com.sakuray.code.practice.leetcode._0_99;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class _033_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }


    /**
     *      -
     *   -
     * -
     *              -
     *          -
     * num[mid] < num[h]  mid在后半段，意味着mid右边一定有序
     * num[mid] >= num[h] mid在左半段，意味着mid左边一定有序
     */
    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = (l + h) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[h]) {  // 右边有序
                if (nums[mid] < target && nums[h] >= target) {  // 一定在右边
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {    // 左边有序
                if (nums[mid] > target && nums[l] <= target) {  // 一定在左边
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}