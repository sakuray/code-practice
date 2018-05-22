package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given an integer, convert it to a roman numeral.
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
public class _012_IntegerToRoman {

	public static void main(String[] args) {
		System.out.println("CMXCIX".equals(intToRoman(999)));
		System.out.println("XCVIII".equals(intToRoman(98)));
		System.out.println("XXXV".equals(intToRoman(35)));
		System.out.println("XXX".equals(intToRoman(30)));
		System.out.println("MDCCCLXXXVIII".equals(intToRoman(1888)));
		System.out.println("MMMCMXCIX".equals(intToRoman(3999)));
	}
	
	public static String intToRoman(int num) {
		if(num > 0 && num < 4000) {
			StringBuilder sb = new StringBuilder();
			char[] roman = new char[]{
				'I','V','X','L','C','D','M'
			};
			int digits = 1;
			int remainder = -1;
			while(num != 0) {
				remainder = num % 10;
				num = num / 10;
				if(remainder < 4) { // 小于4用三个连续的
					for(int i = 0; i < remainder; i++) {
						sb.append(roman[(digits - 1) * 2]);
					}
				} else if(remainder < 9) { // 4~8之间需要借助5的倍数，注意逆序
					remainder = remainder - 5;
					if(remainder >= 0) {
						for(int i = 0; i < Math.abs(remainder); i++) {
							sb.append(roman[(digits - 1) * 2]);
						}
						sb.append(roman[(digits - 1) * 2 + 1]);
					} else { // 4的情况
						sb.append(roman[(digits - 1) * 2 + 1]);
						sb.append(roman[(digits - 1) * 2]);
					}
				} else if(remainder == 9) { // 9需要借助高位减本位，注意逆序
					sb.append(roman[digits*2]);
					sb.append(roman[(digits - 1)*2]);
				}
				digits++;
			}
//			System.out.println(sb.reverse().toString());
			return sb.reverse().toString();
		}
        return null;
    }
	
	public static String intToRoman_S(int num) {
	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
}
