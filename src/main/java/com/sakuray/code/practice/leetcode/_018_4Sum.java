package com.sakuray.code.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
	For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	A solution set is:
	[
  		[-1,  0, 0, 1],
  		[-2, -1, 1, 2],
  		[-2,  0, 0, 2]
	]
 */
public class _018_4Sum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0).toArray()));
		System.out.println(Arrays.toString(fourSum(new int[] {-2, 1, 1, 2}, 2).toArray()));
		// [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		System.out.println(Arrays.toString(fourSum(new int[] {-3,-2,-1,0,0,1,2,3}, 0).toArray()));
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums != null && nums.length > 3) {
			Arrays.sort(nums);
			int l = 0;
			while(l < nums.length - 3) {
				int mid = l + 1, sum = target - nums[l];
				// 从mid到r的三数和问题
				for(int i = mid; i < nums.length - 2; i++) {
					if(i == mid || (i > mid && nums[i] != nums[i-1])) {
						int l2 = i + 1, r = nums.length - 1, gap = sum - nums[i];
						while(l2 < r) {
							if(nums[l2] + nums[r] == gap) {
								result.add(Arrays.asList(nums[l], nums[i], nums[l2], nums[r]));
								while(l2 < r && nums[l2] == nums[l2+1]) l2++;
								while(l2 < r && nums[r] == nums[r-1]) r--;
								l2++; r--;
							} else if(nums[l2] + nums[r] < gap) l2++;
							else r--;
						}
					}
				}
				while(l < nums.length - 3 && nums[l] == nums[l+1]) {
					l++;
				}
				l++;
			}
		}
        return result;
    }
	
	public List<List<Integer>> fourSum_S(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}
}
