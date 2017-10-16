package com.sakuray.code.practice.offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class _07_斐波那契数列 {
	
	public static void main(String[] args) {
		System.out.println(Fibonacci(9));
	}

	public static int Fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return Fibonacci(n-1) + Fibonacci(n-2);
    }
	
	// 最佳答案
	public int Fibonacci_S(int n){
		int a=1,b=1,c=0;
        if(n<0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            for (int i=3;i<=n;i++){
                c=a+b;
                b=a;
                a=c;
            }
            return c;
        }
	}
}
