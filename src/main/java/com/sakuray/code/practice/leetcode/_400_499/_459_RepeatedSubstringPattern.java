package com.sakuray.code.practice.leetcode._400_499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
	Example 1:
		Input: "abab"
		Output: True
		Explanation: It's the substring "ab" twice.
	Example 2:
		Input: "aba"
		Output: False
	Example 3:
		Input: "abcabcabcabc"
		Output: True
		Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.) 
 *
 */
public class _459_RepeatedSubstringPattern {

	public static void main(String[] args) {
//		System.out.println(false == repeatedSubstringPattern(""));
//		System.out.println(true == repeatedSubstringPattern("abab"));
//		System.out.println(false == repeatedSubstringPattern("aba"));
//		System.out.println(true == repeatedSubstringPattern("abcabcabcabc"));
//		System.out.println(true == repeatedSubstringPattern("aaaa"));
//		System.out.println(false == repeatedSubstringPattern("a"));
//		System.out.println(true == repeatedSubstringPattern("abacababacab"));
		System.out.println(true == repeatedSubstringPattern("abacababacaba"));
	}
	
	public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() < 2) return false;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        int cycleLength = 1;
        boolean isCycle = true;
        for(int i = 1; i < s.length() && cycleLength * 2 <= s.length(); i++) {
        	int p = i; isCycle = true;
        	while(p < s.length()) {
        		if(s.charAt(p) != list.get((p - i) % cycleLength)) {
        			isCycle = false;
        			break;
        		}
        		p++;
        	}
        	if(isCycle && s.length() % cycleLength == 0) return true;
        	list.add(s.charAt(i));
        	cycleLength++;
        	System.out.println(Arrays.toString(list.toArray()) +"begin:" + i + ",end:" + p + ",length:" + cycleLength);
        }
        return isCycle && s.length() % cycleLength == 0;
    }
	
	public boolean repeatedSubstringPattern_S(String str) {
		int l = str.length();
		for(int i=l/2;i>=1;i--) {
			if(l%i==0) {
				int m = l/i;
				String subS = str.substring(0,i);
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<m;j++) {
					sb.append(subS);
				}
				if(sb.toString().equals(str)) return true;
			}
		}
		return false;
	}
}
