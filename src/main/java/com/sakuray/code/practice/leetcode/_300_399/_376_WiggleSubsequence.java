package com.sakuray.code.practice.leetcode._300_399;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. 
 * The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. 
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, 
 * leaving the remaining elements in their original order.
 * 
 * Examples:
	Input: [1,7,4,9,2,5]
	Output: 6
	The entire sequence is a wiggle sequence.

	Input: [1,17,5,10,13,15,10,5,16,8]
	Output: 7
	There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

	Input: [1,2,3,4,5,6,7,8,9]
	Output: 2
   Follow up:
	Can you do it in O(n) time?
 */
public class _376_WiggleSubsequence {

	public static void main(String[] args) {
		System.out.println(wiggleMaxLength(new int[] {1,7,4,9,2,5}));	// 6
		System.out.println(wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));	// 7
		System.out.println(wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));	// 2
		System.out.println(wiggleMaxLength(new int[] {1}));	// 1
		System.out.println(wiggleMaxLength(new int[] {1,2}));	// 2
		System.out.println(wiggleMaxLength(new int[] {1,1}));	// 1
		System.out.println(wiggleMaxLength(new int[] {5,5,4,5,3,5,2,5,1}));	// 8
	}
	
	public static int wiggleMaxLength(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int length = 1, sign = 0, cur = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(cur == nums[i]) continue;	// 相等继续
			if(sign == 0) {	// 未判断当前趋势
				sign = (cur < nums[i]) ? 1 : -1;
				cur = nums[i];
				length++;
			} else {	// 已判断当前趋势
				if((nums[i] - cur)*sign < 0) { // 趋势相反
					sign *= -1;
					length++;
				}
				cur = nums[i];
			}
		}
		return length;
    }
	
	public int wiggleMaxLength_S(int[] nums) {
        int s=1;
        int n=nums.length;
        if(n==0)
            return 0;
        while(s<n&&nums[s]==nums[s-1]){
            s++;
        }
        if(s==n)
            return 1;
        int mx=1;
        boolean inc=nums[s]>nums[0];
        int p=nums[0];
        for(int i=s;i<n;i++){
            if((inc&&nums[i]>p)||(!inc&&nums[i]<p)){
                mx++;
                inc=!inc;
            }
            p=nums[i];
        }
        return mx;
    }
}
