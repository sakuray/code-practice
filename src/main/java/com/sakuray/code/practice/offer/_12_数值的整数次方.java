package com.sakuray.code.practice.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class _12_数值的整数次方 {

	public static void main(String[] args) {
		System.out.println(Power(3, -3));
	}
	
	public static double Power(double base, int exponent) {
		if(exponent == 0) return 1;
		if(exponent == 1 || base == 0) return base;
		double sum = base;
		for(int i = 1; i < Math.abs(exponent); i++) {
			sum *= base;
		}
		return exponent > 0 ? sum : 1.0/sum;
	}
}
