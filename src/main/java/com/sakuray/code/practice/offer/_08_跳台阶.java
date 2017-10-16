package com.sakuray.code.practice.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * J(1)=1
 * J(2)=2
 * J(3)=J(2)+J(1)
 * J(4)=J(3)+J(2) // 因为4有多少种跳法等于3的跳法(+1步)+2的跳法(+2步)
 */
public class _08_跳台阶 {

	public static void main(String[] args) {
		System.out.println(JumpFloor(6));
	}
	
	public static int JumpFloor(int target) {
		if(target <= 2 && target >=0) return target;
		int a = 1, b = 2, c= 0;
		for(int i=3; i<=target; i++) {
			c = a+b;
			a = b;
			b = c;
		}
		return c;
    }
	
	// 最佳答案
	public int JumpFloor_S(int target) {
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = one+ two;
            one = two;
            two = result;
        }
        return result;
    }
}
