package com.sakuray.code.practice.offer;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _28_数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }

    // 1.对冲,如果存在一个数字占一半以上，那么其一定是在能对冲掉其它数值的
    // 2.排序,处于中间位置的一定是目标值
    public static int MoreThanHalfNum_Solution(int[] array) {
        if(array == null || array.length == 0) return 0;
        int count = 1; int target = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] == target) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                count = 1;
                target = array[i];
            }
        }
        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(target == array[i]) count++;
        }
        return (count > array.length / 2) ? target : 0;
    }


    public int MoreThanHalfNum_Solution_S(int [] array) {
        int len=array.length;
        if(len<1){
            return 0;
        }
        int count=0;
        Arrays.sort(array);
        int num=array[len/2];
        for(int i=0;i<len;i++){
            if(num==array[i])
                count++;
        }
        if(count<=(len/2)){
            num=0;
        }
        return num;
    }
}
