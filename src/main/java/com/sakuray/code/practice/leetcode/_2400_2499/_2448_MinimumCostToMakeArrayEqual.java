package com.sakuray.code.practice.leetcode._2400_2499;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
 * You can do the following operation any number of times:
 * Increase or decrease any element of the array nums by 1.
 * The cost of doing one operation on the ith element is cost[i].
 * Return the minimum total cost such that all the elements of the array nums become equal.
 * <p>
 * Input: nums = [1,3,5,2], cost = [2,3,1,14]
 * Output: 8
 * Explanation: We can make all the elements equal to 2 in the following way:
 * - Increase the 0th element one time. The cost is 2.
 * - Decrease the 1st element one time. The cost is 3.
 * - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
 * The total cost is 2 + 3 + 3 = 8.
 * It can be shown that we cannot make the array equal with a smaller cost.
 * <p>
 * Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
 * Output: 0
 * Explanation: All the elements are already equal, so no operations are needed.
 */
public class _2448_MinimumCostToMakeArrayEqual {

    /**
     * 将nums的数值变成一样，每次+1-1都会触发cost，求最低的代价
     * 简单来说就是找到指定的nums[k]作为一样的数值，确定变成它的代价，找到最小的
     * 1.暴力求解，每个数值都认为是nums[k]，计算相关代价，取最小
     * 2.二分法，先初始化每个值的代价，如果存在多个相同的数值，cost累加。然后判断最小数值和最大数值的移动代价，每次取最小的
     */
    public long minCost(int[] nums, int[] cost) {
        Map<Integer, Integer> costMap = new HashMap<>();
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < nums.length; i++) {
            costMap.put(nums[i], cost[i] + costMap.getOrDefault(nums[i], 0));
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        long result = 0;
        long minCost = costMap.get(min);
        long maxCost = costMap.get(max);
        while (min < max) {
            if (minCost <= maxCost) {
                result += minCost;
                min++;
                minCost += costMap.getOrDefault(min, 0);
            } else {
                result += maxCost;
                max--;
                maxCost += costMap.getOrDefault(max, 0);
            }
        }
        return result;
    }
}
