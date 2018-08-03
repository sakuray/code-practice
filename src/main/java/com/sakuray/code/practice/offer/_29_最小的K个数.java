package com.sakuray.code.practice.offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class _29_最小的K个数 {

    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution_S(new int[]{4,5,1,6,2,7,3,8}, 4));
//        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 8));
    }

    // 直接排序居然没有超时，部分快排却超时了
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>(k);
        if(input == null || k == 0 || input.length < k) return result;
        int n = -1;int start = 0; int end = input.length - 1;
        while(n != k - 1 && n != k) {
            n = partition(input, start, end);
            if(n < k) {
                start = n + 1;
            } else if(n > k+1) {
                end = n - 1;
            }
        }
//        Arrays.sort(input);
        for(int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static int partition(int[] input, int start, int end) {
        int i = start, j = end;
        int target = input[i];
        while(i < j) {
            while(i < j && input[j] > target) {
                j--;
            }
            if(i < j) {
                input[i] = input[j];
            }
            while(i < j && input[i] < target) {
                i++;
            }
            if(i < j) {
                input[j] = input[i];
            }
        }
        input[i] = target;
        return i;
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution_S(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(input.length < k || k == 0)
            return list;

        for (int i = 0; i < k; i++)
            list.add(input[i]);

        for (int i = k; i < input.length; i++) {
            int j = getMax(list);
            int temp = (Integer) list.get(j);
            if (input[i] < temp)
                list.set(j, input[i]);
        }
        return list;
    }

    public static int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }
}
