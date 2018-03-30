package com.sakuray.code.practice.leetcode;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 * non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
Some examples:
	"1 + 1" = 2
	" 2-1 + 2 " = 3
	"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
 */
public class _224_BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(calculate("2-(5-6)"));	// 3
		System.out.println(calculate("2+(4-(5-6))+5"));	// 3
	}
	
	public static int calculate(String s) {
		char ch; int sum = 0, num = 0, negative = 1;
		for(int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				num = num * 10 + ch - 48;
			} else if('+' == ch) {
				sum += num * negative;
				negative = 1;
				num = 0;
			} else if('-' == ch){
				sum += num * negative;
				negative = -1;
				num = 0;
			} else if('(' == ch) {
				int[] result = calculateParentheses(s, i+1);
				sum += negative*result[0];
				i = result[1];
			}
		}
		sum += num*negative;
        return sum;
    }
	
	public static int[] calculateParentheses(String s, int start) {
		int[] answer = new int[2];
		char ch; int sum = 0, num = 0, negative = 1,i;
		for(i = start; i < s.length(); i++) {
			ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				num = num * 10 + ch - 48;
			} else if('+' == ch) {
				sum += num * negative;
				negative = 1;
				num = 0;
			} else if('-' == ch){
				sum += num * negative;
				negative = -1;
				num = 0;
			} else if('(' == ch) {
				int[] result = calculateParentheses(s, i+1);
				sum += negative*result[0];
				i = result[1];
			} else if(')' == ch) {
				sum += num*negative;
				break;
			}
		}
		answer[0] = sum;
		answer[1] = i;
		return answer;
	}
	
	public int calculate_S(String s) {
        this.eval(s.toCharArray(), 0, s.length());
        return this.result;
    }

    private int result;
    private static int value(int sign, int val) {
        //return sign*val;
        return sign < 0 ? -val : val;
    }

    private int eval(char[] cs, int pos, int limit) {
        int value1 = 0;
        int value2 = 0;
        int sign = 1;
        EVAL_LOOP: while (pos < limit) {
            char c = cs[pos++];
            switch (c) {
                case ' ':
                    break;
                case '(':
                    pos = this.eval(cs, pos, limit);
                    value1 += value(sign, this.result);
                    value2 = 0;
                    sign = 1;
                    break;
                case ')':
                    break EVAL_LOOP;
                case '+':
                    value1 += value(sign, value2);
                    value2 = 0;
                    sign = 1;
                    break;
                case '-':
                    value1 += value(sign, value2);
                    value2 = 0;
                    sign = -1;
                    break;
                default:
                    value2 = value2 * 10 + c - '0';
                    break;
            }
        }
        this.result = value1 + value(sign, value2);
        return pos;
    }
}
