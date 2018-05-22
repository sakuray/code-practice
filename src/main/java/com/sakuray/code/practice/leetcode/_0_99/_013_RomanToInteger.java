package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 罗马记数规则：
 * 	I  1
 * 	V  5
 *  X  10
 *  L  50
 *  C  100
 *  D  500
 *  M  1000
 *  
 *  相同的数字连写，表示相加,如III=3
 *  小的数在大数右边，表示相加VIII=8 XII=12
 *  小的数在大数左边，表示相减IV=4 IX = 9
 *  连写的数字不超过3次
 *  数字上画横线，表示扩大1000倍
 *  IXC自身连用，放在大数右边不能超过3个，大数左边只能1个
 *  VLD不能放在大数左边做减法，放在右边，只能使用一个
 */
public class _013_RomanToInteger {
	
	public static void main(String[] args) {
		System.out.println(romanToInt("CMXCIX")==999);
		System.out.println(romanToInt("XCVIII")==98);
		System.out.println(romanToInt("XXXV")==35);
		System.out.println(romanToInt("XXX")==30);
		System.out.println(romanToInt("MDCCCLXXXVIII")==1888);
		System.out.println(romanToInt("MMMCMXCIX")==3999);	
	}

    public static int romanToInt(String s) {
    	int num = 0;
    	for(int i = 0; i < s.length(); i++) {
    		switch(s.charAt(i)) {
    			case 'I':
    				if(i != s.length() - 1 && s.charAt(i+1) != 'I') {
    					num -= 1;
    				} else {
    					num += 1;
    				}
    				break;
    			case 'V':num += 5;break;
    			case 'X':
    				if(i != s.length() - 1 && (s.charAt(i+1) == 'L' 
    					|| s.charAt(i+1) == 'C')) {
    					num -= 10;
    				} else {
    					num += 10;
    				}
    				break;
    			case 'L':num += 50;break;
    			case 'C':
    				if(i != s.length() - 1 && (s.charAt(i+1) == 'D' 
    						|| s.charAt(i+1) == 'M')) {
    					num -= 100;
    				} else {
    					num += 100;
    				}
    				break;
    			case 'D':num += 500;break;
    			case 'M':num += 1000;break;
    			default:throw new RuntimeException("超过范围，未知字符");
    		}
    	}
        return num;
    }
    
    public int romanToInt_S(String s) {
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}
       
        char c[]=s.toCharArray();
        int count=0;
       
        for(;count<=s.length()-1;count++){
        	if(c[count]=='M') sum+=1000;
        	if(c[count]=='D') sum+=500;
        	if(c[count]=='C') sum+=100;
        	if(c[count]=='L') sum+=50;
        	if(c[count]=='X') sum+=10;
        	if(c[count]=='V') sum+=5;
        	if(c[count]=='I') sum+=1;
        }
        return sum;
   }
}
