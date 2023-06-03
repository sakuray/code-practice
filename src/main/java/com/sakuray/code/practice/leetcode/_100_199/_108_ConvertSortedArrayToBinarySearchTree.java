package com.sakuray.code.practice.leetcode._100_199;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
 * the two subtrees of every node never differ by more than 1.
Example:
	Given the sorted array: [-10,-3,0,5,9],
	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 */
import static com.sakuray.code.practice.leetcode.Tools.*;

public class _108_ConvertSortedArrayToBinarySearchTree {
	
	public static void main(String[] args) {
		System.out.println(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) return null;
        return toBST(0, nums.length - 1, nums);
    }
	
	public static TreeNode toBST(int start, int end, int[] nums) {
		if(start == end) return new TreeNode(nums[end]);
		int length = end - start + 1;
		int mid = (length % 2 == 0) ? length / 2 + start : length / 2 + start;
		TreeNode parent = new TreeNode(nums[mid]);
		parent.left = toBST(start, mid - 1, nums);
		if(mid != end) {
			parent.right = toBST(mid + 1, end, nums);
		}
		return parent;
	}
	
	public TreeNode sortedArrayToBST_S(int[] nums) {
        if(nums==null){return null;}
        TreeNode root = sortAtBhelper(nums,0,nums.length-1);
        return root;
    }
    public TreeNode sortAtBhelper(int[] nums, int left, int right){
        if(left>right){return null;}
        int mid = (left+right)/2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left=sortAtBhelper(nums,left,mid-1);
        temp.right=sortAtBhelper(nums,mid+1,right);
        return temp;
    }
}
