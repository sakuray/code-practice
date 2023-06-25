package com.sakuray.code.practice.leetcode.common;

/**
 * 位运算：<a href="http://graphics.stanford.edu/~seander/bithacks.html"></a>
 * 题目：
 * 136.找只需要一次的数字。a ^ a = 0, 0 ^ a = a
 * 191.二进制中包含多少个1。 n & (n - 1)会将二进制位最后一位置为0
 * 231.判断是否是2的幂次。n & (n - 1) == 0
 * 268.找到缺失的序号，使得当前序号成对出现，a ^ a = 0, 0 ^ a = a
 */
public class Bit {

    public static void main(String[] args) {
        // 1.将字符转小写
        System.out.println(('a' | ' ') == 'a');
        System.out.println(('A' | ' ') == 'a');
        // 2.将字符大写
        System.out.println(('b' & '_') == 'B');
        System.out.println(('B' & '_') == 'B');
        // 3.大小写互换
        System.out.println(('c' ^ ' ') == 'C');
        System.out.println(('C' ^ ' ') == 'c');
        // 4.交换两个值
        int a = 1, b = 2;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + "..." + b);
        // 5. +1
        System.out.println(-~a);
        // 6. -1
        System.out.println(~-a);
        // 7. 判断两个数字符号是否不同
        System.out.println((a ^ b) < 0);
        b = -2;
        System.out.println((a ^ b) < 0);
        // 8. 环形数组转圈 index % arr.length， length是2的n次幂
        // 改成 index & arr.length - 1, index--也可以，不需要管负号，但是%需要
        // 9. n & (n-1)  消除数字 n 的二进制表示中的最后一个 1
        // n - 1 一定可以消除最后一个 1，同时把其后的 0 都变成 1，这样再和 n 做一次 & 运算，就可以仅仅把最后一个 1 变成 0 了。
        // 10.a ^ a = 0
        // 一个数和它本身做异或运算结果为 0，即 a ^ a = 0；一个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a
    }

}
