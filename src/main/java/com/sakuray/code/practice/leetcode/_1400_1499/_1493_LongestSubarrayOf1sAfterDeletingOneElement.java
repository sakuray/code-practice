package com.sakuray.code.practice.leetcode._1400_1499;

/**
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 * <p>
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * <p>
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * <p>
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 */
public class _1493_LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,1}));
    }

    /**
     * 必须删除一个元素，判断最长连续1的长度
     */
    public static int longestSubarray(int[] nums) {
        int max = 0, delete = 0, pre = 0, cur = 0;
        for (int num : nums) {
            if (num == 0) {
                // 理论上要delete
                if (delete != 0) {
                    max = Math.max(max, pre + cur);
                } else {
                    delete = 1;
                }
                // 重置当前1计数为0，pre为当前值
                pre = cur;
                cur = 0;
            } else {
                cur++;
            }
        }
        int lastResult = delete == 0 ? pre + cur - 1 : pre + cur;
        return Math.max(max, lastResult);
    }
}
