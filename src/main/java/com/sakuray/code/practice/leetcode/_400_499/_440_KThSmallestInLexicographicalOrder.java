package com.sakuray.code.practice.leetcode._400_499;

/**
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
   Note: 1 ≤ k ≤ n ≤ 109.
	Example:
	Input:	n: 13   k: 2
	Output:	10
	Explanation:
		The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 *
 */
public class _440_KThSmallestInLexicographicalOrder {

	public static void main(String[] args) {
		System.out.println(findKthNumber(109, 2));	// 10
		System.out.println(findKthNumber(123, 15));	// 111
		System.out.println(findKthNumber(123, 34));	// 18
		System.out.println(findKthNumber(2, 2));	// 2
		System.out.println(findKthNumber(681692778, 351251360));	// 416126219
		System.out.println(findKthNumber(681692778, 555555555));	// 599999999
	}
	
	public static int findKthNumber(int n, int k) {
		int length = 0, tmp = n;
		while(tmp != 0) {
			length++;
			tmp = tmp / 10;
		}
//		System.out.println("length:"+ length +", n:" + n);
		int result = 0;
		while(k > 0) {
			int cur = 0;
			for(; cur <= 9; cur++) {	// 计算当前位的值
				if(cur == 0 && result == 0) continue;	// 首位不能为0
				int base = 1; int len = length; int size = 0;
				while(len > 0) {	// 计算当前值的所有可能数量
					int left = result * base * 10 + cur * base;
					int right = left + base;
					if(left == n) {
						size+=1;
					} else if(left < n && n < right) {
						size+=(n-left+1);
					} else if(n >= right){
						size+= base;
					}
					base*=10;
					len--;
				}
				if(size < k) {
					k-=size;
				} else {
					k--;
					break;
				}
			}
			result = result * 10 + cur;
//			System.out.println("result:" +result);
			length--;
		}
//		System.out.println("k：" + k);
		return result;
	}
	
	public int findKthNumber_S(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = calSteps(n, cur, cur + 1);
            if (steps <= k) {
                cur = cur + 1;
                k -= steps;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
    
    private int calSteps(int n, long cur, long next) {
        int steps = 0;
        while (cur <= n) {
            steps += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return steps;
    }
}
