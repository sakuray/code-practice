package com.sakuray.code.practice.leetcode._700_799;

/**
 * You're given strings J representing the types of stones that are jewels, 
 * and S representing the stones you have.  Each character in S is a type of stone you have.  
 * You want to know how many of the stones you have are also jewels.
	The letters in J are guaranteed distinct, and all characters in J and S are letters. 
	Letters are case sensitive, so "a" is considered a different type of stone from "A".
Example 1:
	Input: J = "aA", S = "aAAbbbb"
	Output: 3
Example 2:
	Input: J = "z", S = "ZZ"
	Output: 0
Note:
	S and J will consist of letters and have length at most 50.
	The characters in J are distinct.
 *
 */
public class _771_JewelsAndStones {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
		System.out.println(numJewelsInStones("ebd", "bbb"));
	}
	
	public static int numJewelsInStones(String J, String S) {
		if(J == null || S == null) return 0;
		int count = 0;
		char[] j = J.toCharArray();
		char[] s = S.toCharArray();
		int[] aim = new int[52];
		for(int i = 0; i < j.length; i++) {
			if(j[i] <= 90) aim[j[i]-65] = 1;
			else aim[j[i]-71]=1;
		}
		for(int i = 0; i < s.length; i++) {
			if(s[i] <= 90) count+=aim[s[i]-65];
			else count+=aim[s[i]-71];
		}
        return count;
    }
	
	public int numJewelsInStones_S(String J, String S) {
        int jewelTot = 0;
        for(char stone : S.toCharArray()){
            if(J.indexOf(stone) != -1) jewelTot++;
        }
        return jewelTot;
    }
}
