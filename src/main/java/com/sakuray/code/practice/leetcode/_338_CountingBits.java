package com.sakuray.code.practice.leetcode;

import java.util.Arrays;

/**
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
Example:
	For num = 5 you should return [0,1,1,2,1,2].
Follow up:
	It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
	But can you do it in linear time O(n) /possibly in a single pass?
	Space complexity should be O(n).
	Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class _338_CountingBits {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(5)));
	}
	
	public static int[] countBits(int num) {
		int[] result = new int[num+1];
		for(int i = 0; i <= num; i++) {
			int cur = i;
			cur = (cur & 0x55555555) + (cur >> 1 & 0x55555555);
			cur = (cur & 0x33333333) + (cur >> 2 & 0x33333333);
			cur = (cur & 0x0f0f0f0f) + (cur >> 4 & 0x0f0f0f0f);
			cur = (cur * 0x01010101) >> 24;
			result[i] = cur;
		}
        return result;
    }
	
	/**
	 * f[i] = f[i >> 1] + (i & 1);  等于右移动一位+当前右位是否为1
	 */
	public int[] countBits_S(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; ++i)
			ans[i] = ans[i & (i - 1)] + 1;
		return ans;
	}
}
