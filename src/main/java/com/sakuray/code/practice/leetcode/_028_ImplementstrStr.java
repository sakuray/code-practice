package com.sakuray.code.practice.leetcode;


/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
	Input: haystack = "hello", needle = "ll"
	Output: 2
   Example 2:
	Input: haystack = "aaaaa", needle = "bba"
	Output: -1
 */
public class _028_ImplementstrStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("bbaa", "aaa"));
		System.out.println(strStr("aab", "ab"));
		System.out.println(strStr("", "ab"));
		System.out.println(strStr("ab", ""));
		System.out.println("aaab".indexOf("ab"));
	}
	
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null) return -1;
		if(needle.length() == 0) return 0;
		for(int i = 0; i < haystack.length(); i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				// 查看剩下的字符是否相等
				int j = 1;
				for(; j < needle.length() && i + j < haystack.length(); j++) {
					if(needle.charAt(j) != haystack.charAt(i+j)) {
						break;
					}
				}
				if(j == needle.length()) {
					return i;
				}
			}
		}
        return -1;
    }
	
	public int strStr_S(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}
}
