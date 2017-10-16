package com.sakuray.code.practice.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class _11_二进制中1的个数 {

	public static void main(String[] args) {
		System.out.println(NumberOf1(-2));
	}
	
	public static int NumberOf1(int n) {
		int count = 0;
		while(n != 0) {
			if((n&1) == 1) count++;
			n = n>>>1;
		}
		return count;
    }
	
	// 最佳答案
	public int NumberOf1_S(int n) {
        int t=0;
            char[]ch=Integer.toBinaryString(n).toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='1'){
                    t++;
                }
            }
            return t;
    }
	
	public int NumberOf1_SS(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
         }
        return count;
    }
}
