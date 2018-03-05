package com.sakuray.code.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 2 abc
 * 3 def
 * 4 ghi
 * 5 jkl
 * 6 mno
 * 7 pqrs
 * 8 tuv
 * 9 wxyz
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class _017_LetterCombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(letterCombinations("23").toArray()));
	}
	
	public static List<String> letterCombinations(String digits) {
		char[][] nums = new char[][] {
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
		};
		List<String> result = new ArrayList<>();
		if(digits != null && !digits.isEmpty()) {
			combination("", digits, 0, nums, result);
		}
        return result;
    }
	
	public static void combination(String lastResult, String digits, int index, char[][] map, List<String> result) {
		if(index == digits.length()) {
			result.add(lastResult);
			return;
		}
		int num = Integer.parseInt(""+digits.charAt(index));
		if(num == 0 || num == 1) {
			combination(lastResult, digits, index+1, map, result);
		} else {
			for(int i = 0; i < map[num - 2].length; i++) {
				combination(lastResult+map[num-2][i], digits, index+1, map, result);
			}
		}
	}
	
	public static List<String> letterCombinations_S(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    if(digits.isEmpty()) return ans;
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}

}
