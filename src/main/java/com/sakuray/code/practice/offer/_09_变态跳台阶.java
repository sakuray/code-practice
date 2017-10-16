package com.sakuray.code.practice.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * J(1)=1
 * J(2)=1+J(1)
 * J(3)=1+J(2)+J(1)
 * ...
 * J(n)-J(n-1)=J(n-1)
 * J(n)=2^(n-1)
 */
public class _09_变态跳台阶 {

	public static void main(String[] args) {
		System.out.println(JumpFloorII(16));
	}
	
	public static int JumpFloorII(int target) {
		if(target == 0 || target == 1) return target;
		int sum = 1;
		for(int i = 0; i < target - 1; i++) {
			sum = 2*sum;
		}
		return sum;
    }
	
	// 最佳答案
	public int JumpFloorII_S(int target) {
        if(target == 0) {
            return 0;
        }
         
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
         
        for(int i = 2;i <= target;i++) {
            dp[i] = 0;
            for(int j = 0;j < i;j++) {
                dp[i] += dp[j];
            }
        }
         
        return dp[target];
    }
}
