package com.sakuray.code.practice.leetcode._700_799;

import java.util.Arrays;

/**
 * Given a list of sorted characters letters containing only lowercase letters, 
 * and given a target letter target, find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'. 
 * Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 */
public class _744_FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		System.out.println('c' == nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
		System.out.println('f' == nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
		System.out.println('f' == nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'd'));
		System.out.println('j' == nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'g'));
		System.out.println('c' == nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'j'));
		System.out.println('c' == nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'k'));
	}
	
	public static char nextGreatestLetter2(char[] letters, char target) {
		char result = letters[0];
		int gap = Integer.MAX_VALUE;
		for(int i = 0; i < letters.length; i++) {
			int g = letters[i] + 26 - target;
			if(g < gap && g > 26) {
				gap = g;
				result = letters[i];
			}
		}
        return result;
    }
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int length = letters.length;
		if(target >= letters[length - 1]) return letters[0];
		int l = 0; int r = letters.length - 1;
		while(l < r) {
			int mid = (l + r) / 2;
			if(letters[mid] > target) {
				r = mid;
			} else if(letters[mid] <= target) {
				l = mid+1;
			}
		}
		return letters[r];
    }
	
	// 本身有序
	public char nextGreatestLetter_S(char[] letters, char target) {
	    int i = Arrays.binarySearch(letters, (char) (target + 1));
	    return letters[i >= 0 ? i : ~i % letters.length];
	}
}
