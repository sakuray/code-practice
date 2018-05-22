package com.sakuray.code.practice.leetcode._300_399;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
	Example 1:
		Input:8
		Output:3
		Explanation:8 -> 4 -> 2 -> 1
	Example 2:
		Input:7
		Output:4
		Explanation:7 -> 8 -> 4 -> 2 -> 1 or 7 -> 6 -> 3 -> 2 -> 1
 */
public class _397_IntegerReplacement {

	public static void main(String[] args) {
		System.out.println(1==integerReplacement(0));
		System.out.println(0==integerReplacement(1));
		System.out.println(1==integerReplacement(2));
		System.out.println(2==integerReplacement(3));
		System.out.println(2==integerReplacement(4));
		System.out.println(3==integerReplacement(5));
		System.out.println(3==integerReplacement(6));
		System.out.println(4==integerReplacement(7));
		System.out.println(3==integerReplacement(8));
		System.out.println(32==integerReplacement(12344123));
	}
	
	/**
	 * 0111  就加1 移位 总共4步
	 * 1000  就直接移位 总共3步
	 * 0101 减1移动2位
	 * 11才进行加法，加1移动2位总共3步，减1移动1减1移动1总共4步,有一种情况是做减法，只有2个1的时候
	 * 01的时候做减法，减1移动2位即可，加1移动减1再移动要4步，
	 * 除非前面没有其他1，加1移动1步就可以了，但是前面没数字本来就是1已经出结果了
	 */
	public static int integerReplacement(int n) {
		if(n == 0) return 1;
		int count = 0;
		List<Integer> list = new ArrayList<>();
		while(n != 1) {
			int remainder = n % 2;
			n = n / 2;
			list.add(remainder);
		}
		list.add(n);
		boolean carry = false;
		while(list.size() != 1) {
			int cur = list.get(0);
			if((cur == 0 && !carry) || (cur == 1 && carry)) { // 当前位实际为0，移动一位
				count++;
			} else { // 当前位实际上是1,就要加1或减1进行移位
				if(carry) carry = false; // 进位导致的1
				count+=2;
				if(list.size() > 2 && list.get(1) == 1) carry = true;	// 2个连续的1需要进位
			}
			list.remove(0);
		}
		if((list.get(0) == 0 && !carry) || (list.get(0) == 1 && carry)) {
			count++;
		}
        return count;
    }
	
	//When n is even, the operation is fixed. The procedure is unknown when it is odd. 
	//When n is odd it can be written into the form n = 2k+1 (k is a non-negative integer.). 
	//That is, n+1 = 2k+2 and n-1 = 2k. Then, (n+1)/2 = k+1 and (n-1)/2 = k. So one of (n+1)/2 and (n-1)/2 is even, the other is odd. 
	//And the “best” case of this problem is to divide as much as possible. Because of that,
	//always pick n+1 or n-1 based on if it can be divided by 4. The only special case of that is when n=3 you would like to pick n-1 rather than n+1.
    public static int integerReplacement_S(int n) {
        if (n == Integer.MAX_VALUE) return 32; //n = 2^31-1;
        int count = 0;
        while (n > 1){
            if (n % 2 == 0) n  /= 2;
            else{
                if ( (n + 1) % 4 == 0 && (n - 1 != 2) ) n++;
                else n--;
            }
            count++;
        }
        return count;
    }
}
