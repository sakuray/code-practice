package com.sakuray.code.practice.leetcode._400_499;

import java.util.Arrays;

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * Follow up:
 * Could you solve it using only O(1) extra space?
	Example 1:
		Input:["a","a","b","b","c","c","c"]
		Output:Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
		Explanation:"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
	Example 2:
		Input:["a"]
		Output:Return 1, and the first 1 characters of the input array should be: ["a"]
		Explanation:Nothing is replaced.
	Example 3:
		Input:["a","b","b","b","b","b","b","b","b","b","b","b","b"]
		Output:Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
		Explanation:Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
		Notice each digit has it's own entry in the array.
	Note:
		All characters have an ASCII value in [35, 126].
		1 <= len(chars) <= 1000.
 */
public class _443_StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("abbbbbbbbbbbb".toCharArray()));
		System.out.println(compress("ab".toCharArray()));
		System.out.println(compress("a".toCharArray()));
		System.out.println(compress("aabbccc".toCharArray()));
	}
	
	public static int compress(char[] chars) {
		if(chars == null || chars.length == 0) return 0;
		int length = 0; char c = chars[0]; int count = 0;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == c) count++;
			else if(count == 1) {chars[length] = c; length++; c=chars[i];}
			else{
				chars[length] = c;
				char[] nums = String.valueOf(count).toCharArray();
				for(char n : nums) {
					length++;
					chars[length] = n;
				}
				length++;
				c = chars[i];
				count=1;
			}
		}
		if(count==1) {
			chars[length] = c;
		}
		if(count > 1) {
			chars[length] = c;
			char[] nums = String.valueOf(count).toCharArray();
			for(char n : nums) {
				length++;
				chars[length] = n;
			}
		}
		System.out.println(Arrays.toString(chars));
        return length+1;
    }
	
	public int compress_S(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        int res = 0, len = 1, j = 0, i = 0;
        for(i = 1; i < chars.length; i++){
            if(chars[i] != chars[i-1]){
                if(len == 1) {
                    res += 1;
                    chars[j++] = chars[i-1];
                }
                else if(len < 10) {
                    res += 2;
                    chars[j++] = chars[i-1];
                    chars[j++] = (char)(len+'0');
                }
                else if(len < 100) {
                    res += 3;
                    chars[j++] = chars[i-1];
                    chars[j++] = (char)(len/10 + '0');
                    chars[j++] = (char)(len - (len/10 * 10) + '0');
                }
                else if(len < 1000) {
                    res += 4;
                    chars[j++] = chars[i-1];
                    chars[j++] = (char)(len/100 + '0');
                    len = len - (len / 100) * 100;
                    chars[j++] = (char)(len / 10 + '0');
                    len = len - (len /10) * 10;
                    chars[j++] = (char)(len + '0');
                }
                else {
                    res += 5;
                    chars[j++] = chars[i-1];
                    chars[j++] = '1';
                    chars[j++] = '0';
                    chars[j++] = '0';
                    chars[j++] = '0';
                }
                len = 1;
            }
            else len++;
        }
        
        
                if(len == 1) {
                    res += 1;
                    chars[j++] = chars[i-1];
                }
                else if(len < 10) {
                    res += 2;
                    chars[j++] = chars[i-1];
                    chars[j++] = (char)(len + '0');
                }
                else if(len < 100) {
                    res += 3;
                    chars[j++] = chars[i-1];
                    chars[j++] = (char)(len/10 + '0');
                    chars[j++] = (char)(len - (len/10 * 10) + '0');
                }
                else if(len < 1000) {
                    res += 4;
                    chars[j++] = chars[i-1];
                    chars[j++] = (char)(len/100 + '0');
                    len = len - (len / 100) * 100;
                    chars[j++] = (char)(len / 10 + '0');
                    len = len - (len /10) * 10;
                    chars[j++] = (char)(len + '0');
                }
                else {
                    res += 5;
                    chars[j++] = chars[i-1];
                    chars[j++] = '1';
                    chars[j++] = '0';
                    chars[j++] = '0';
                    chars[j++] = '0';
                }
        
        return res;
    }
}