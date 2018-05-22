package com.sakuray.code.practice.leetcode._400_499;


/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S. 
 * 
 * Example 1:
		Input: nums is [1, 1, 1, 1, 1], S is 3. 
		Output: 5
   Explanation: 
		-1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
	There are 5 ways to assign symbols to make the sum of nums be target 3.
   Note:
	The length of the given array is positive and will not exceed 20.
	The sum of elements in the given array will not exceed 1000.
	Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class _494_TargetSum {

	public static void main(String[] args) {
		System.out.println(5 == findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
		System.out.println(10 == findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 1));
	}
	
	public static int findTargetSumWays(int[] nums, int S) {
        return combinate(nums, 0, S, 0);
    }
	
	public static int combinate(int[] nums, int index, int target, int last) {
		if(index < nums.length) {
			int size = combinate(nums, index+1, target, last+nums[index]);
			size = size + combinate(nums, index+1, target, last-nums[index]);
			return size;
		} else {
			return last == target ? 1 : 0;
		}
	}
	
	
	public int findTargetSumWays_S(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 全为正都比目标小 无组合方式
        // nums所有数值之和 大于目标值  就必须有一些正一些负相互抵消，假设抵消n 则 sum = 2*n + s 所以sum + s必定是偶数
        // 也只需要计算nums中加起来等于(sum + s) / 2 =  n + s的组合
        return  sum < S || (sum + S) % 2 == 1 ? 0 : helper(nums, (sum + S) / 2);
    }
	
	// 计算nums中加起来等于n + s = sum的组合, 动态规划
	// 计算array[n]中存放的是到达n的走法可能性
	// 和台阶问题类似,10层台阶1次走1~2阶，有多少种走法
	// http://www.sohu.com/a/153858619_466939
    private int helper(int[] nums, int sum) {
        int[] array = new int[sum + 1];
        array[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j - nums[i] >= 0; j--) {
                array[j] += array[j - nums[i]];
            }
        }
        return array[sum];
    }
}
