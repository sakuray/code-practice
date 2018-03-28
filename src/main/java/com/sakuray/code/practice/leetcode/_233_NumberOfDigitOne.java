package com.sakuray.code.practice.leetcode;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
   For example:
		Given n = 13,
		Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class _233_NumberOfDigitOne {

	public static void main(String[] args) {
		System.out.println(2 == countDigitOne(10));
		System.out.println(6 == countDigitOne(13));
		System.out.println(20 == countDigitOne(99));
		System.out.println(12 == countDigitOne(20));
		System.out.println(300 == countDigitOne(999));
		System.out.println(281 == countDigitOne(909));
		System.out.println(292 == countDigitOne(919));
		System.out.println(293 == countDigitOne(929));
		System.out.println(51499 == countDigitOne(101089));
		System.out.println(1638 == countDigitOne(2112));
	}
	
	/**
	 * 个位：8*last+degree*1+last+last   1
	 * 十位：8*last+degree*1+last+last  	20
	 * 百位：8*last+degree*1+last+last	300
	 */
	public static int countDigitOne(int n) {
		if(n < 1) return 0;
		int origin = n;
		int count = 0, degree = 1, last = 0;
		while(n > 0) {
			int remainder = n % 10;
			n = n / 10;
			if(remainder > 1) {
				count += remainder*last+degree;
			} else if(remainder == 1) {
				count += last;
				count += origin % degree + 1;
			}
			last = 10 * last + degree * 1;
			degree *= 10;
		}
        return count;
    }
	
	public int countDigitOne_S(int n) {
        //边界值考虑<=0
		int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }
}
