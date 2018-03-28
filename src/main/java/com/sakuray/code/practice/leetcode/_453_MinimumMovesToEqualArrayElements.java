package com.sakuray.code.practice.leetcode;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 * Example:
 		Input:[1,2,3]
		Output:3
   Explanation:
   		Only three moves are needed (remember each move increments two elements):
		[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class _453_MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		System.out.println(minMoves(new int[] {1,2,3}));
		System.out.println(minMoves(new int[] {1,2}));
	}
	
	/**
	 * 数学问题：假设最终值是X，移动了M次
	 * sum + M*(n-1) = X*n
	 * 要M最小，则 X = min + M
	 * sum - M = min*n
	 * M = sum - min * n
	 */
	public static int minMoves(int[] nums) {
		int n = nums.length;
		int min = nums[0];
		int sum = nums[0];
		for(int i = 1; i < n; i++) {
			sum+=nums[i];
			if(min > nums[i]) min = nums[i];
		}
        return sum - min * n;
    }
	
	public int minMoves_S(int[] nums) {
        int sum=0;
        int min=nums[0];
        for(int num:nums){
            sum+=num;
            if(num<min)
                min=num;
        }
        return sum-(min*nums.length);
    }
}
