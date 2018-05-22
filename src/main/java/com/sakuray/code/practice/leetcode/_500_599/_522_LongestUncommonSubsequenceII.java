package com.sakuray.code.practice.leetcode._500_599;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them.
 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings
 * and this subsequence should not be any subsequence of the other strings.
 *
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters
 * without changing the order of the remaining elements.
 * Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 *
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
 * If the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example 1:
 *  Input: "aba", "cdc", "eae"
 *  Output: 3
 * Note:
 *  All the given strings' lengths will not exceed 10.
 *  The length of the given list will be in the range of [2, 50].
 */
public class _522_LongestUncommonSubsequenceII {
	
	public static void main(String[] args) {
		System.out.println(3 == findLUSlength(new String[] {"aba", "cdc", "eae"}));
		System.out.println(2 == findLUSlength(new String[] {"aabbcc", "aabbcc", "cb", "abc"}));
		System.out.println(6 == findLUSlength(new String[] {"aabbcc", "cb", "abc"}));
	}

	/**
	 * 根据问题描述：多个字符串的其中一个字符串的子串不是其他字符串的子串，求最长的那个。
	 * 最长就意味着是该字符串本身，也就会更容易满足不是其他字符串的子串这一条件。 
	 * 注意没说一定要连续
	 */
	public static int findLUSlength(String[] strs) {
		int maxLength = -1;
		// 判断当前i字符串是否是最大的子串
		for(int i = 0; i < strs.length; i++) {
			if(strs[i].length() > maxLength) {	// 只有比当前大才有判断是否是其他字符串子串的必要
				int j = 0;
				for(; j < strs.length; j++) {
					if(i == j || strs[i].length() > strs[j].length()) continue; // 当前字符串更长，肯定不是其他字符串的子串
					if(isSubsequence(strs[i], strs[j])) break;
				}
				if(strs.length == j) {	// strs[i]满足所有条件
					maxLength = strs[i].length();
				}
			}
		}
		return maxLength;
    }
	
	/**
	 * 判断s1是否是s2的子串
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isSubsequence(String s1, String s2) {
		int i1 = 0, i2 = 0;
		for(; i2 < s2.length() && i1 < s1.length(); i2++) {
			if(s1.charAt(i1) == s2.charAt(i2)) {
				i1++;
			}
		}
		return i1 == s1.length();
	}
}
