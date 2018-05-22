package com.sakuray.code.practice.leetcode._100_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
	For example:
   Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].
 *
 */
public class _199_BinaryTreeRightSideView {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		l1.left = l2;
		l1.right = l3;
		l2.right = l5;
		l3.right = l4;
		// 第二种测试
//		l1.left = l2;
//		l1.right = l3;
//		l3.left = l4;
		System.out.println(rightSideView(l1));
	}
	
	// 难点在于右子树深度比左子树小的时候，左子树也会进入结果
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        search(root, 0, 0, result);
        return result;
    }
	
	public static int search(TreeNode root, int nowDepth, int searchDepth, List<Integer> list) {
		if(root == null) return searchDepth;
		if(nowDepth >= searchDepth) {
			list.add(root.val);
			searchDepth++;
		}
		int rightMax = search(root.right, nowDepth+1, searchDepth, list);
		int leftMax = search(root.left, nowDepth+1, rightMax, list);
		return Math.max(rightMax, leftMax);
	}
	
	public List<Integer> rightSideView_S(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root, int h){
        //operation at node
        h += 1;
        if(h > result.size()){
            result.add(root.val);
        }
        
        //generate children
        if(root.right != null){
            dfs(result, root.right, h);
        }
        
        if(root.left != null){
            dfs(result, root.left, h);
        }
        
        //leaving this node
        h -= 1;       
    }   

}
