package com.sakuray.code.practice.leetcode;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Example:
   Given nums = [3,2,2,3], val = 3,
   Your function should return length = 2, with the first two elements of nums being 2.
 */
public class _027_RemoveElement {

	public static void main(String[] args) {
		int[] a = new int[] {3,2,2,3,3,3,1,1,1,3,3};
		System.out.println(removeElement(a, 3) + "---" + Arrays.toString(a));
	}
	
	public static int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0) return 0;
		int index = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				if(index != i) {
					nums[index] = nums[i];
				}
				index++;
			}
		}
        return index;
    }
	
	public int removeElement_S(int[] A, int elem) {
	   int m = 0;    
	   for(int i = 0; i < A.length; i++){
	       if(A[i] != elem){
	           A[m] = A[i];
	           m++;
	       }
	   }
	   return m;
	}
}
