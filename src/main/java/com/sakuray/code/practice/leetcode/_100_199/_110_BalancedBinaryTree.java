package com.sakuray.code.practice.leetcode._100_199;

import com.sakuray.code.practice.leetcode.Tools;
import com.sakuray.code.practice.leetcode.Tools.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example 1:
	Given the following tree [3,9,20,null,null,15,7]:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Return true.

Example 2:
	Given the following tree [1,2,2,3,3,null,null,4,4]:
	       1
	      / \
	     2   2
	    / \
	   3   3
	  / \
	 4   4
	Return false.
 */
public class _110_BalancedBinaryTree {

	public static void main(String[] args) {
		System.out.println(true == isBalanced(Tools.buildTreeByArray(new Integer[] {3,9,20,null,null,15,7})));
		System.out.println(false == isBalanced(Tools.buildTreeByArray(new Integer[] {1,2,2,3,3,null,null,4,4})));
		System.out.println(true == isBalanced(Tools.buildTreeByArray(new Integer[] {})));
		System.out.println(false == isBalanced(Tools.buildTreeByArray(new Integer[] {1,null,2,null,3})));
	}
	
	// 深度优先搜索
	public static boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		int[] result = new int[1];
		dfs(root, 1, result);
		return result[0] != 1;
    }
	
	public static int dfs(TreeNode root, int depth, int[] result) {
		int left = 0, right = 0;
		if(root.left != null) {
			left = dfs(root.left, depth + 1, result);
		}
		if(root.right != null) {
			right = dfs(root.right, depth + 1, result);
		}
		if(Math.abs(left - right) > 1) { 
			result[0] = 1; 
		}
		return (left > right ? left : right) + 1;
	}
	
	public boolean isBalanced_S(TreeNode root) {
		boolean ret;
		if (root == null)
			ret = true;
		else if (root.left == null && root.right == null) {
			ret = true;
		} else if (root.left == null) {
			if (maxDepth(root.right) > 1)
				ret = false;
			else
				ret = true;
		} else if (root.right == null) {
			if (maxDepth(root.left) > 1)
				ret = false;
			else
				ret = true;
		} else {
			if (isBalanced(root.right) && isBalanced(root.left)) {
				if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
					ret = false;
				else
					ret = true;
			}

			else
				ret = false;
		}
		// System.out.println("For node = " + root.val + " returned " + ret);
		return ret;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.right == null && root.left == null) {
			return 1;
		} else if (root.right == null) {
			return 1 + maxDepth(root.left);
		} else if (root.left == null) {
			return 1 + maxDepth(root.right);
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}
}
