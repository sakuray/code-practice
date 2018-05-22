package com.sakuray.code.practice.leetcode._0_99;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class _020_ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("["));
		System.out.println(isValid(""));
	}
	
	public static boolean isValid(String s) {
		int index = 0;
		if(s != null && !s.isEmpty()) {
			int[] nums = new int[16];
			for(int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
					case '(' : 
						nums[index] = 1; index++; 
						if(index == nums.length - 1) {
							int[] newNum = new int[nums.length*2];
							System.arraycopy(nums, 0, newNum, 0, nums.length);
							nums = newNum;
						}
						break;
					case '{' : 
						nums[index] = 2; index++;
						if(index == nums.length - 1) {
							int[] newNum = new int[nums.length*2];
							System.arraycopy(nums, 0, newNum, 0, nums.length);
							nums = newNum;
						}
						break;
					case '[' : 
						nums[index] = 3; index++;
						if(index == nums.length - 1) {
							int[] newNum = new int[nums.length*2];
							System.arraycopy(nums, 0, newNum, 0, nums.length);
							nums = newNum;
						}
						break;
					case ']' : 
						if(index == 0 || nums[index - 1] != 3) {
							return false;
						} else {
							index--;
						}
						break;
					case '}' :
						if(index == 0 || nums[index - 1] != 2) {
							return false;
						} else {
							index--;
						}
						break;
					case ')':
						if(index == 0 || nums[index - 1] != 1) {
							return false;
						} else {
							index--;
						}
						break;
					default:
						break;
				}
			}
		}
		if(index != 0) {
			return false;
		} else {
			return true;
		}
    }
	
	public static boolean isValid_S(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
