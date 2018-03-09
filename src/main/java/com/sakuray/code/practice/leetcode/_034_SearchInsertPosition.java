package com.sakuray.code.practice.leetcode;


/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array. 
 *  Example 1:
		Input: [1,3,5,6], 5
		Output: 2
	Example 2:
		Input: [1,3,5,6], 2
		Output: 1
	Example 3:
		Input: [1,3,5,6], 7
		Output: 4
	Example 1:
		Input: [1,3,5,6], 0
		Output: 0

 */
public class _034_SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 0));
		System.out.println(searchInsert(new int[] {1}, 1));
		System.out.println(searchInsert(new int[] {1}, 2));
		System.out.println(searchInsert(new int[] {2}, 1));
		System.out.println(searchInsert(new int[] {1,3}, 2));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(nums[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
    }
	
	public int searchInsert_S(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
