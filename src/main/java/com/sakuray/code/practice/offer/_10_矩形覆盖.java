package com.sakuray.code.practice.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * R(1) = 1
 * R(2) = 2
 * R(3) = 3
 * R(4) = 5
 */
public class _10_矩形覆盖 {

	public static void main(String[] args) {
		System.out.println(RectCover(3));
	}
	
	public static int RectCover(int target) {
		if(target <=2 && target>=0) return target;
		int a = 1, b =2, c = 0;
		for(int i = 3; i <= target; i++) {
			c = a+b;
			a = b;
			b = c;
		}
		return c;
    }
	
	// 最佳答案
	public int RectCover_S(int target) {
        if(target<=1){
            return 1;
        }
        else if(target==2){
            return 2;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
