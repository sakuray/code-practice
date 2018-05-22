package com.sakuray.code.practice.leetcode._0_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *  [
  		"((()))",
  		"(()())",
  		"(())()",
  		"()(())",
  		"()()()"
	]
 */
public class _022_GenerateParentheses {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateParenthesis(0).toArray()) + "---length:" +generateParenthesis(0).size());
		System.out.println(Arrays.toString(generateParenthesis(1).toArray()) + "---length:" +generateParenthesis(1).size());
		System.out.println(Arrays.toString(generateParenthesis(2).toArray()) + "---length:" +generateParenthesis(2).size());
		System.out.println(Arrays.toString(generateParenthesis(3).toArray()) + "---length:" +generateParenthesis(3).size());
		System.out.println(Arrays.toString(generateParenthesis(4).toArray()) + "---length:" +generateParenthesis(4).size());
	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<>();
		generate(n, 0, 0, result, "");
        return result;
    }
	
	
	public static void generate(int n, int l, int r, List<String> result, String last) {
		if(n == r && n == l) {
			if(!last.isEmpty()) {
				result.add(last);
			}
			return;
		}
		if(l == 0) {
			generate(n, l + 1, r, result, last+"(");
		} else {
			if(l < n) {
				generate(n, l + 1, r, result, last + "(");
			}
			if(r < n && r < l) {
				generate(n, l, r + 1, result, last + ")");
			}
		}
	}
	
	public List<String> generateParenthesis_S(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
	
	
}
