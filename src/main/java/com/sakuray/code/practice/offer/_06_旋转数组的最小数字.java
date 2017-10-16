package com.sakuray.code.practice.offer;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class _06_旋转数组的最小数字 {
	
	public static void main(String[] args) {
		int[] array = {3,4,5,1,2,7}; //{1,3,4,5};
		System.out.println(minNumberInRotateArray(array));
		System.out.println(Arrays.toString(array));
	}

	// 审题有错，非递减排序的数组是递增，不一定单调
	public static int minNumberInRotateArray(int [] array) {
	    if(array == null || array.length == 0) return 0;
	    int min = array[0],index = 0;
	    for(int i = 1; i < array.length; i++) {
	    	if(min>array[i]) {
	    		min = array[i];
	    		index = i;
	    	}
	    }
	    int disc = array.length % index;
	    if(disc == 0) {
	    	int temp;
	    	for(int i = 0; i < index; i++) {
	    		temp = array[i];
	    		array[i] = array[i+index];
	    		array[i+index] = temp;
	    		System.out.println(Arrays.toString(array)+"||||");
	    	}
	    } else {
	    	int count = array.length+1;
	    	int temp, i = 0, cur = -1;
	    	while(count != 0) {
	    		temp = array[i];
	    		array[i] = cur;
	    		cur = temp;
	    		i += disc;
	    		if(i > array.length - 1) {
		    		i = i % array.length;
		    	}
	    		count--;
	    		System.out.println(Arrays.toString(array)+"====");
	    	}
	    }
	    return min;
    }
	
	// 最佳答案
	public int minNumberInRotateArray_S(int[] array) {
        if (array.length == 0)
            return 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        return array[0];
    }
	
	public static int minNumberInRotateArray_SS(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

}
