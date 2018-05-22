package com.sakuray.code.practice.leetcode._500_599;


/**
 * Given a string and an integer k, you need to reverse the first k characters 
 * for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original.
	Example:
		Input: s = "abcdefg", k = 2
		Output: "bacdfeg"
	Restrictions:
		The string consists of lower English letters only.
		Length of the given string and k will in the range [1, 10000]
 *
 */
public class _541_ReverseStringII {

	public static void main(String[] args) {
		System.out.println("bacdfeg".equals(reverseStr("abcdefg", 2)));
		System.out.println("cbadefg".equals(reverseStr("abcdefg", 3)));
		System.out.println("gfedcba".equals(reverseStr("abcdefg", 8)));
	}
	
	public static String reverseStr(String s, int k) {
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++) {
			int end = i + k - 1;
			end = end < c.length ? end : c.length - 1;
			for(int b = i; b < end;b++, end--) {
				char tmp = c[b];
				c[b] = c[end];
				c[end] = tmp;
			}
			i += 2 * k - 1;
		}
		System.out.println(new String(c));
        return new String(c);
    }
	
	public String reverseStr_S(String s, int k) {
		if (s == null || s.length() == 0)
			return "";
		int len = s.length();
		int i = 0;
		char[] arr = s.toCharArray();
		while (i < len) {
			int j = Math.min(i + k - 1, len - 1);
			swap(arr, i, j);
			i = i + (2 * k);
		}
		return new String(arr);
	}

	private void swap(char[] arr, int l, int r) {
		while (l < r) {
			char tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
	}
}
