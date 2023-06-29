package com.sakuray.code.practice.leetcode._900_999;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given an array of integers arr, sort the array by performing a series of pancake flips.
 * In one pancake flip we do the following steps:
 * Choose an integer k where 1 <= k <= arr.length.
 * Reverse the sub-array arr[0...k-1] (0-indexed).
 * For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3,
 * we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
 * Return an array of the k-values corresponding to a sequence of pancake flips that sort arr.
 * Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
 * <p>
 * Input: arr = [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: arr = [3, 2, 4, 1]
 * After 1st flip (k = 4): arr = [1, 4, 2, 3]
 * After 2nd flip (k = 2): arr = [4, 1, 2, 3]
 * After 3rd flip (k = 4): arr = [3, 2, 1, 4]
 * After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
 * <p>
 * Input: arr = [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 */
public class _969_PancakeSorting {

    /**
     * 找到最大的下标，把他翻转到最上面，然后再翻转到最下面，递归找第二大的，这个不是最优解
     * 先想下，有10个值，你想将位置7移动到位置3，保持其他值顺序不变，要怎么做？
     * 目标是1~2，7，3~6，8~10
     * 1.翻转7，这样变成了7~1，8~10(永远不变)
     * * 关键点1：最大是10，翻转<=7不会影响最大8~10的位置
     * 2.翻转5，这样变成了3~7，2~1(产生了前面的1~2)，8~10
     * * 关键点2：移动到3意味着1-2，3-6需要拆成2部分。之前翻转了7-1，再转【7-3+1】=5次，就能分割出1-2
     * 3.翻转4，这样变成了6~3，7(产生了单独的7)，2~1，8~10
     * * 关键点3：分割出7，且要翻转成逆序，前面7已经处于中间位置，后面2-1是逆序，前面是正序，切分出7，需要再翻转【7-3+1】-1 = 4次
     * 4.翻转7，这样就变成了1~2，7，3~6，8~10
     * * 关键点4：将逆序改正
     * 关键问题：如果想7和3交换位置怎么做？
     * 步骤1：翻转7
     * 步骤2：翻转[7-3]+1，前序是5
     * 步骤3：翻转[7-3]+1-1，前序是4， 得到顺序 6-3，7，2-1，8-10
     * 步骤4：翻转[7-3]+1-1-1，前序是3，得到顺序 4-6，3，7，2-1，8-10
     * 步骤5：翻转[7-3]+1-1-1+1，前序2组，得到顺序3，6-4，7，2-1，8-10
     * 步骤6：翻转7，得到1-2，7，4-6，3，8-10。顺利将7位置和3位置互换了
     * 我们得到一组翻转顺序，将a和b的位置互换,a从0开始
     * a
     * a - b + 1
     * a - b
     * a - b -1
     * a - b
     * a
     */
    List<Integer> pancakeSort(int[] arr) {
        // 1.记录下标顺序，cakes是值+index，indexs记录的是index + 值(由于值做下标，需要-1，运算时需要加回来)
        int[] indexs = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexs[arr[i] - 1] = i;
        }
        // 2.开始两两交换顺序，从应该在0位置的数字开始
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < indexs.length; i++) {
            // 当前值i + 1的位置是index，其应该去到i位置
            int index = indexs[i];
            // 保留交换顺序
            dew(stack, i, index);
            // 数值转换和下标
            indexs[arr[i]-1] = index;
            indexs[i] = i;
            arr[index] = arr[i];
            arr[i] = i+1;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while(!stack.isEmpty()) {
            int x = stack.pop();
            ans.addFirst(x);
        }
        return ans;
    }

    private void dew(Stack<Integer> stack, int j, int i) {
        if(i != j) {
            add(stack, i+1);
            add(stack, i-j+1);
            add(stack, i-j);
            add(stack, i-j-1);
            add(stack, i-j);
            add(stack, i+1);
        }
    }

    private void add(Stack<Integer> stack, int x) {
        if(x > 1) {
            if(!stack.isEmpty() && stack.peek() == x) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }
    }

    void sort(int[] cakes, int n, List<Integer> result) {
        if (n == 1) {
            return;
        }
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }
        reverse(cakes, 0, maxCakeIndex);
        result.add(maxCakeIndex + 1);
        reverse(cakes, 0, n - 1);
        result.add(n);
        sort(cakes, n - 1, result);
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
