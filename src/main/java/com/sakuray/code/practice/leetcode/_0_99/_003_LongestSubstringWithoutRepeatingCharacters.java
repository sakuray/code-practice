package com.sakuray.code.practice.leetcode._0_99;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3. 
	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _003_LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvda"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        String subString = s.substring(0, 1);
        int maxLength = 0;
        int start = 0;
        for(int i = 1; i < s.length(); i++) {
        	int index = subString.indexOf(s.charAt(i));
        	if(index < 0) {
        		subString = s.substring(start, i + 1);
        	} else {
        		int length = subString.length();
        		if(length > maxLength) maxLength = length;
        		subString = s.substring(start + index + 1, i + 1);
        		start = start + index + 1;
        	}
        }
        if(subString.length() > maxLength) maxLength = subString.length();
        return maxLength;
    }
	
	public static int lengthOfLongestSubstring_S(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
