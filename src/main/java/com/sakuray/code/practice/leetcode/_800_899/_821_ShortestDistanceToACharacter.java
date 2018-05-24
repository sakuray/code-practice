package com.sakuray.code.practice.leetcode._800_899;

import com.sakuray.code.practice.leetcode.PrintTools;

/**
 * Given a string S and a character C, 
 * return an array of integers representing the shortest distance from the character C in the string.
 * 
 * Example 1:
	Input: S = "loveleetcode", C = 'e'
	Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
   Note:
	S string length is in [1, 10000].
	C is a single character, and guaranteed to be in string S.
	All letters in S and C are lowercase.
 */
public class _821_ShortestDistanceToACharacter {

	public static void main(String[] args) {
		PrintTools.printArray(shortestToChar("loveleetcode", 'e'));
	}
	
	public static int[] shortestToChar(String S, char C) {
		char[] s = S.toCharArray();
		int[] aim = new int[s.length]; int aimS = 0;
		int[] result = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			if(s[i] == C) {
				aim[aimS] = i;
				aimS++;
			}
		}
		int index = 0;	// 后一个目标的坐标
		for(int i = 0; i < result.length; i++) {
			if(index == 0 && i < aim[index]) {
				result[i] = aim[index] - i;
			} else {
				if(i < aim[index]) {
					result[i] = Math.min(i-aim[index-1], aim[index]-i);
				} else if(i == aim[index] && index < aimS-1) {
					index++;
				} else {
					result[i] = i - aim[index];
				}
			}
		}
        return result;
    }
}
