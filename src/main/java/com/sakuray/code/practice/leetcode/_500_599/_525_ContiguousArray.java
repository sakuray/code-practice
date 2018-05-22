package com.sakuray.code.practice.leetcode._500_599;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

找出1和0数量相等的最长子串
 *
 */
public class _525_ContiguousArray {

	public static void main(String[] args) {
		System.out.println(2 == findMaxLength(new int[] {0, 1, 1, 1, 0}));
		System.out.println(2 == findMaxLength(new int[] {0, 1}));
		System.out.println(2 == findMaxLength(new int[] {0, 1, 0}));
		System.out.println(6 == findMaxLength(new int[] {0, 1, 1, 1, 0, 0, 1}));
		System.out.println(6 == findMaxLength(new int[] {0,0,0,1,1,1,0}));
	}
	
	/**
	 *   [0 0 0 1 1 1 1 1 0]
	 *  0-1-2-3-2-1 0 1 2 1
	 * -1 0 1 2 3 4 5 6 7 8
	 * maxLength 两个值相距的最大距离
	 */
	public static int findMaxLength(int[] nums) {
		if(nums == null || nums.length < 2) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0; map.put(sum, -1); int length = 0;
		for(int i = 0; i < nums.length; i++) {
			sum = (nums[i] == 0) ? sum - 1: sum + 1;
			if(map.containsKey(sum)) {
				length = Math.max(length, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		System.out.println(length);
        return length;
    }
	
	/**
	 * 下列算法原理和上面基本一致
	 * 如果当前步为0 意味着没有走到过这里，标记当前位置
	 * 如果当前步不为0，意味着曾经走到过这里，计算两次的差距
	 * +2是因为边界问题，如果i是0则还是0，需要改变成不为0的情况。
	 */
	public static int findMaxLength_S(int[] nums) {
		System.out.println(Arrays.toString(nums));
        int len = nums.length;
        int[] map = new int[len*2+1];
        int cp = len;
        map[cp] = 1;
        int max = 0;
        for(int i=0; i<len; i++) {
            cp += nums[i]*2-1;//-1 or 1
            if(map[cp] == 0) {
                map[cp] = i+2;
            }else {
                max = Math.max(max, i-map[cp]+2);
            }
            System.out.println(Arrays.toString(map));
        }
        return max;
    }
}
