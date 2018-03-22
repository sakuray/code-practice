package com.sakuray.code.practice.leetcode;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
Follow up:
	If this function is called many times, how would you optimize it?
 */
public class _190_ReverseBits {
	
	public static void main(String[] args) {
		System.out.println(964176192 == reverseBits(43261596));
	}

	public static int reverseBits(int n) {
		int result = 0;
		for(int i = 0; i < 32; i++) {
			result += n & 1;
			if(i != 31) result <<= 1;
			n >>>= 1;
		}
		return result;
    }
	
	public int reverseBits_S(int n) {
		int res = n;
		res = res << 16 | res >>> 16;
		res = (res & 0x00ff00ff) << 8 | (res & 0xff00ff00) >>> 8;
		res = (res & 0x0f0f0f0f) << 4 | (res & 0xf0f0f0f0) >>> 4;
		res = (res & 0x33333333) << 2 | (res & 0xcccccccc) >>> 2;
		res = (res & 0x55555555) << 1 | (res & 0xaaaaaaaa) >>> 1;
		return res;
	}
}
