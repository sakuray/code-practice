package com.sakuray.code.practice.leetcode._0_99;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
 * you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 */
public class _009_PalindromeNumber {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(111));
		System.out.println(isPalindrome(21112));
		System.out.println(isPalindrome(1111));
		System.out.println(isPalindrome(-2147447412));
	}

	public static boolean isPalindrome(int x) {
		if(x < 0 ) return false;
		List<Integer> bit = new ArrayList<>();
		while(x != 0) {
			bit.add(x % 10);
			x = x / 10;
		}
		for(int i = 0; i < bit.size() / 2; i++) {
			if(bit.get(i) != bit.get(bit.size() - i - 1)) {
				return false;
			}
		}
        return true;
    }
	
	public static boolean IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome, 
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123, 
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
