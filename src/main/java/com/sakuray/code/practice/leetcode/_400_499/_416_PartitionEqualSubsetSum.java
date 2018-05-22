package com.sakuray.code.practice.leetcode._400_499;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Note:
	Each of the array element will not exceed 100.
	The array size will not exceed 200.
   Example 1:
		Input: [1, 5, 11, 5]
		Output: true
		Explanation: The array can be partitioned as [1, 5, 5] and [11].
   Example 2:
   		Input: [1, 2, 3, 5]
		Output: false
		Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class _416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(true == canPartition(new int[] {1, 5, 11, 5}));
		System.out.println(true == canPartition(new int[] {1, 2, 3, 4, 5, 6, 7}));
		System.out.println(true == canPartition(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
		System.out.println(false == canPartition(new int[] {1, 2, 3, 5}));
		System.out.println(true == canPartition(new int[] {}));
		System.out.println(false == canPartition(new int[] {2}));
		System.out.println(false == canPartition(new int[] {2,2,4,6}));
//		System.out.println(true == canPartition(new int[] {28,63,95,30,39,16,36,44,37,100,61,73,32,
//				71,100,2,37,60,23,71,53,70,69,82,97,43,16,33,29,5,97,32,29,78,93,59,37,88,89,79,75,
//				9,74,32,81,12,34,13,16,15,16,40,90,70,17,78,54,81,18,92,75,74,59,18,66,62,55,19,2,
//				67,30,25,64,84,25,76,98,59,74,87,5,93,97,68,20,58,55,73,74,97,49,71,42,26,8,87,99,1,16,79}));
//		System.out.println(true == canPartition(new int[] {71,70,66,54,32,63,38,98,4,22,61,40,6,8,6,
//				21,71,36,30,34,44,60,89,53,60,56,73,14,63,37,15,58,51,88,88,32,80,32,10,89,67,29,68,
//				65,34,15,88,8,57,78,37,63,73,65,47,39,32,74,31,44,43,4,10,8,96,22,58,87,29,99,79,13,
//				96,21,62,71,34,55,72,3,96,7,36,64,30,6,14,87,12,90,40,13,29,21,94,33,99,86,4,100}));
		System.out.println(true == canPartition(new int[] {88,29,42,97,15,74,16,52,59,28,86,35,50,99,
				50,94,46,74,16,94,52,24,90,60,37,68,85,74,96,22,16,50,11,70,39,68,97,11,46,27,44,78,
				35,26,84,18,93,77,98,47,20,74,100,95,64,75,69,43,16,20,79,30,45,9,69,9,74,98,16,6,13,
				72,53,61,70,71,58,80,64,21,14,27,1,45,75,28,33,5,45,89,99,54,83,58,96,19,25,15,48}));
	}
	
	public static boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0) return true;
		if(nums.length == 1) return false;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {sum += nums[i];}
		if(sum % 2 != 0) return false;
		int aim = sum / 2;
		Arrays.sort(nums);
		if(nums[nums.length - 1] > aim) return false; // 存在比平均值大的数，怎么分都分不平
		
		int[] map = new int[nums.length];		// 搜索辅助用表
		map[0] = nums.length - 1;
		int cur = 0;
		int curIndex = 0;
		int lastIndex = -1;
		System.out.println(Arrays.toString(nums)+"=========="+aim);
		while(curIndex < nums.length) {
			map[curIndex] = nums.length - curIndex - 1;
			cur += nums[map[curIndex]];
			if(cur == aim) { // 找到目标
				return true;
			} else if(cur > aim) { // 当前数值大于目标值，开始回退，第一个不退因为其至少是属于其中一组
				System.out.println(Arrays.toString(map) + curIndex+"..."+cur);
				while(curIndex > 0) {
					if(map[curIndex] != -1) {
						cur -= nums[map[curIndex]];
						lastIndex = curIndex;
						if(map[curIndex] != 0) {
							break;
						}
					}
					curIndex--;
				}
				if(lastIndex != -1) {
					map[lastIndex] = -1;
					curIndex = lastIndex+1;
					lastIndex = -1;
				} else {
					return false;
				}
			} else {
				curIndex++;
				if(curIndex == nums.length) { // 开始回退
					while(curIndex > 0) {
						curIndex--;
						if(map[curIndex] != -1) {
							cur -= nums[map[curIndex]];
							lastIndex = curIndex;
							if(map[curIndex] != 0) {
								break;
							}
						}
						curIndex--;
					}
					if(lastIndex != -1) {
						map[lastIndex] = -1;
						curIndex = lastIndex+1;
						lastIndex = -1;
					} else {
						return false;
					}
				}
			}
		}
        return false;
	}
	
	public boolean canPartition_S(int[] nums) {
        int n = nums.length;
        int total_sum = 0;
        
        for(int i = 0; i < n; i++)
            total_sum += nums[i];
        
        if(total_sum % 2 != 0) return false;
        
        int sum = total_sum/2;
        
        return checkPartitionPossible(nums, n-1, new int[]{sum,sum});
    }
    
    public boolean checkPartitionPossible(int[] nums, int i, int[] sub){
        if(i < 0)
            return sub[0] == 0 && sub[1] == 0;
        
        for(int k=0; k<sub.length; k++){
            if(sub[k] < nums[i])    
                continue;
            sub[k] -= nums[i];
            if(checkPartitionPossible(nums, i-1, sub)) return true;
            sub[k] += nums[i];
        }
        return false;
    }
}
