package com.sakuray.code.practice.leetcode;

/**
 * Write a function that takes a string as input and returns the string reversed.
	Example:
	Given s = "hello", return "olleh".
 *
 */
public class _344_ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}
	
	public static String reverseString(String s) {
        if(s==null) return s;
        char[] c = s.toCharArray();
        for(int i = 0, j = c.length - 1; i < j; i++, j--) {
        	char tmp = c[i];
        	c[i] = c[j];
        	c[j] = tmp;
        }
        return String.valueOf(c);
    }
	
	public String reverseString_S(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            word[i] = (char) (word[i] ^ word[j]);
            word[j] = (char) (word[i] ^ word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            i++;
            j--;
        }
        return new String(word);
    }
}
