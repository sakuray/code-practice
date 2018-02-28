package com.sakuray.code.practice.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class _014_LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println("".equals(longestCommonPrefix(new String[] {"a","a","b"})));
		System.out.println("a".equals(longestCommonPrefix(new String[] {"a","a"})));
		System.out.println("abc".equals(longestCommonPrefix(new String[] {"abca", "abc"})));
		System.out.println("a".equals(longestCommonPrefix(new String[] {"ac", "ac", "a", "a"} )));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs != null && strs.length != 0) {
			String common = strs[0];
			for(int i = 1; i < strs.length; i++) {
				if(common == null) {
					common = strs[i];
				} else if (strs[i] != null) {
					common = common.substring(0, Math.min(common.length(), strs[i].length()));
					for(int j = 0; j < common.length(); j++) {
						if(common.charAt(j) != strs[i].charAt(j)) {
							common = common.substring(0, j);
							break;
						}
					}
					if("".equals(common)) return "";
				}
			}
			return common == null ? "" : common;
		}
        return "";
    }
	
	public String longestCommonPrefix_S(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	public String longestCommonPrefix_S2(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	
	public String longestCommonPrefix_S3(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private String longestCommonPrefix(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix(strs, l , mid);
	        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}
	
	public String longestCommonPrefix_S4(String[] strs) {
	    if (strs == null || strs.length == 0)
	        return "";
	    int minLen = Integer.MAX_VALUE;
	    for (String str : strs)
	        minLen = Math.min(minLen, str.length());
	    int low = 1;
	    int high = minLen;
	    while (low <= high) {
	        int middle = (low + high) / 2;
	        if (isCommonPrefix(strs, middle))
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len){
	    String str1 = strs[0].substring(0,len);
	    for (int i = 1; i < strs.length; i++)
	        if (!strs[i].startsWith(str1))
	            return false;
	    return true;
	}
}
