package com.sakuray.code.practice.leetcode._0_99;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
Example:
	Given nums = [1,1,2],
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
	It doesn't matter what you leave beyond the new length.
 *
 */
public class _026_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] a = new int[]{1,1,2,3,3,4,4,5,6};
		System.out.println(removeDuplicates(a) + "===" + Arrays.toString(a));
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int index = 1, last = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(last != nums[i]) {
				if(index != i) {
					nums[index] = nums[i];
				}
				index++;
				last = nums[i];
			}
		}
        return index;
    }
	
	public int removeDuplicates_S(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
}
