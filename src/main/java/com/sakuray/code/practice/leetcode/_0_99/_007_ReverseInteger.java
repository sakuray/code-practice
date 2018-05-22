package com.sakuray.code.practice.leetcode._0_99;

import java.util.Stack;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
	Example 1:
		Input: 123
		Output:  321
	Example 2:
		Input: -123
		Output: -321
	Example 3:
		Input: 120
		Output: 21
 *	Note:
 *	Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
 *	For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class _007_ReverseInteger {

	public static void main(String[] args) {
		System.out.println(321 == reverse(123));
		System.out.println(-321 == reverse(-123));
		System.out.println(21 == reverse(120));
		System.out.println(654321 == reverse(123456));
		System.out.println(0 == reverse(1534236469));
		System.out.println(0 == reverse(-2147483648));
		System.out.println(0 == reverse(1563847412));
	}
	
	public static int reverse(int x) {
		if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        Stack<Integer> bit = new Stack<>();
        while(x != 0) {
        	bit.push(x % 10);
        	x = x / 10;
        }
        int size = bit.size();
        int index = 1;
        int under = -1;
        for(int i = 0; i < size; i++) {
        	if(i != 0) index *= 10;
        	under = bit.pop();
        	if(index >= 0x10000000 &&  (under > 2 || under < -2  || 
        			(under == 2 && x > Integer.MAX_VALUE - 2000000000) || 
        			(under == -2 && x < Integer.MIN_VALUE + 2000000000))) {
        		return 0;	// 溢出
        	}
        	x += under * index;
        }
		return x;
    }
	
	public static int reverse_S(int x) {
	    int result = 0;
	    while (x != 0) {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result) { 
	        	return 0; 
	        }
	        result = newResult;
	        x = x / 10;
	    }
	    return result;
	}
}
