package com.sakuray.code.practice.leetcode._700_799;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
   S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. 
   More specifically, if x occurs before y in S, then x should occur before y in the returned string.
   Return any permutation of T (as a string) that satisfies this property.
     Example :
	 Input: 
		S = "cba"
		T = "abcd"
	Output: "cbad"
	Explanation: 
		"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
		Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 	Note:
		S has length at most 26, and no character is repeated in S.
		T has length at most 200.
		S and T consist of lowercase letters only.
 */
public class _791_CustomSortString {

	public static void main(String[] args) {
		System.out.println("cbad ===" + customSortString("cba", "abcd"));
	}
	
	public static String customSortString(String S, String T) {
		if(T.length() < 2) return T;
		int[] compare = new int[26];
		for(int i = 0; i < S.length(); i++) {
			compare[S.charAt(i) - 'a'] = i;
		}
		char[] c = T.toCharArray();
		for(int i = 0; i < c.length - 1; i++) {
			for(int j = 0; j < c.length - 1 - i; j++)
			if(compare[c[j] - 'a'] > compare[c[j+1] - 'a']) {
				char tmp = c[j];
				c[j] = c[j+1];
				c[j+1] = tmp;
			}
		}
        return new String(c);
    }
	
	public String customSortString_S(String S, String T) {
        // algorithm 2018/02/28: since letters in String S do not have duplicate,
        //  the problem is to simply find that each letter in S that also occurs in T
        int[] letterOccurrencesInT = new int[26];
        for (char ch: T.toCharArray()) {
            letterOccurrencesInT[ch-'a'] ++;
        }
        
        StringBuilder builder = new StringBuilder();
        for (char ch: S.toCharArray()) {
            if (letterOccurrencesInT[ch-'a'] > 0) {
                for (int count = 0; count < letterOccurrencesInT[ch-'a']; count++) {
                    builder.append(ch);
                }
                letterOccurrencesInT[ch-'a'] = 0;
            } else {
                // no such letter in T. Do nothing
            }
        }
        
        // append remaining letters
        for (int letter = 0; letter < 26; letter++) {
            int  occurrence = letterOccurrencesInT[letter];
            for (int count = 0; count < occurrence; count++) {
                builder.append((char)(letter+'a')); // also applicable to the case when occurrence is 0
            }
        }
        
        return builder.toString();
    }
}
