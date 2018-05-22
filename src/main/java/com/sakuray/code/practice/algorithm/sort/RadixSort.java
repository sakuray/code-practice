package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序：属于分配式排序，又称桶子法。
 * 		透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用
 * 		从个位开始比较，用稳定的算法排序
 * 性能：
 * 		最好时间分析：O(d(n+r))
 * 		最差时间分析：O(d(n+r))
 * 		平均时间分析：O(d(n+r))
 * 		稳定度：稳定
 * 		空间复杂度：O(n+r)
 */
public class RadixSort {

	// obj输入的排序数组，d输入值的最高位数
	public static void sort(int[] obj, int d) {
		int radix = 10;	// 0~9
		int[] count = new int[radix];	// 用于计数排序
		int[] tempArray = new int[obj.length]; // 用于暂存元素
		
		/**
		 * 	个位： i / 1 % 10
		 *	十位: i / 10 % 10
		 *	百位: i / 100 % 10
		 */
		int c = 1;
		for(int i = 1; i <= d; i++) {
			Arrays.fill(count, 0); // 初始化计数
			System.arraycopy(obj, 0, tempArray, 0, obj.length);  
			// 稳定的算法排序
			for(int j = 0; j < obj.length; j++) {
				int temp = (tempArray[j] / c) % radix;
				count[temp]++;
			}
			
			/**
			 * 下面这两步很重要，比较难理解,这两步要连着看，逆向思考。
			 * 第一步就是累加了，指明了具体的位置，举个例子就是：
			 * 下标： 0   1   2   3   4   5   6   7   8   9
			 * 计数： 0	 3   1   2   0   1   1   1   0   0
			 * 下标代表的是该位的实际大小，计数代表的是有多少个，很显然下表为1的排序后在前三个
			 * 所以才会累加计数，变成
			 *       0   3   4   6   6   7   8   9   9   9
			 * 这就意味着为2的应该排在新数组的4位以下，由于2的计数是等于2+2之前的，调序的时候是顺序的-1
			 * 不会越到1的1~3位，因为2只有1个。所以下标为2的那个数实际位置就是第4位，以此类推。
			 * 从右往左分配保证稳定性。保证右边的在相同数字的时候依旧靠右
			 */
			for(int j = 1; j < radix; j++) {
				count[j] = count[j] + count[j-1];
			}
			
			for(int j = obj.length - 1; j >= 0; j--) {
				int temp = (tempArray[j] / c) % radix;
				count[temp]--;
				obj[count[temp]] = tempArray[j];
			}
			c *= radix;
			System.out.println(Arrays.toString(obj));
		}
	}
	
}
