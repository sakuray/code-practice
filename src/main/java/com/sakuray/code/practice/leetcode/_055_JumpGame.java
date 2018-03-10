package com.sakuray.code.practice.leetcode;


/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
   Each element in the array represents your maximum jump length at that position.
   Determine if you are able to reach the last index.
	For example:
		A = [2,3,1,1,4], return true.
		A = [3,2,1,0,4], return false.
 *
 */
public class _055_JumpGame {
	
	public static void main(String[] args) {
//		System.out.println(canJump(new int[] {1, 1, 1, 1, 1}));
//		System.out.println(canJump(new int[] {2, 0, 3, 1, 0}));
//		System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
//		System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
		System.out.println(canJump(new int[] {0}));
		System.out.println(canJump(new int[] {2,0,0}));
	}

	// 判断在i点最多能到达的距离  如在1处  能到达4处，自然能到达2处，2处最多又能到达5
	// 所以只需要判断i要小于当前最大能到达值，查询最大能到达的点即可
	public static boolean canJump(int[] nums) {
		int max = 0;
		for(int i = 0; i < nums.length && i <= max; i++) {
			max = Math.max(nums[i] + i, max);
		}
		return max >= nums.length - 1;
    }
	
	public boolean canJump_S(int[] nums) {
        if(nums.length == 0) return false;
        if(nums.length ==1) return true;
        for(int i= nums.length -2; i>=0; i--){
            if(nums[i] == 0){
                int jumpsNeeded = 1;
                while(jumpsNeeded > nums[i]){
                    jumpsNeeded++;
                    i--;
                    if(i<0) return false;
                }
            }
        }
        return true;
    }
}
