package com.sakuray.code.practice.leetcode._0_99;


/**
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
	Example:
		Input: "babad"
		Output: "bab"
	Note: "aba" is also a valid answer.
 	Example:
		Input: "cbbd"
		Output: "bb"
 */
public class _005_LongestPalindromicSubstring {
	
	
	public static void main(String[] args) {
		System.out.println("bab".equals(longestPalindrome("babad")));
		System.out.println("bb".equals(longestPalindrome("cbbd")));
		System.out.println("bbbb".equals(longestPalindrome("bbbb")));
		System.out.println("bbccbb".equals(longestPalindrome("bbccbb")));
		System.out.println("b".equals(longestPalindrome("b")));
		System.out.println("bb".equals(longestPalindrome("bb")));
		System.out.println("bbb".equals(longestPalindrome("bbb")));
		System.out.println("badab".equals(longestPalindrome("badab")));
	}
	
	public static String longestPalindrome(String s) {
		if(s.length() == 1) return s;
		String result = null;
		for(int i = 0; i < s.length(); i++) {	
//			System.out.println("========="+i + ":" + s.charAt(i));
			// 第一种，当前值为中间值
			int left = 0;
			for(int j = i - 1; j >= 0 && 2*i-j < s.length(); j--) {
				if(s.charAt(j) == s.charAt(2*i-j)) {
					left++;
				} else {
					break;
				}
			}
			if(result == null || 2*left+1 > result.length()) {
				result = s.substring(i - left, i + left + 1);
//				System.out.println("1:"+result);
			}
			// 第二种，当前值为左对称点
			left = 0;
			for(int j = i; j >=0 && 2*i-j + 1 < s.length(); j--) {
				if(s.charAt(j) == s.charAt(2*i-j+1)) {
					left++;
				} else {
					break;
				}
			}
			if(result == null || 2*left > result.length()) {
				result = s.substring(i - left + 1, i + left + 1);
//				System.out.println("2:"+result);
			}
		}
//		System.out.println(result);
		return result;
	}
	
	public static String longestPalindrome_S(String s) {
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
}
