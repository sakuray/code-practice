package com.sakuray.code.practice.leetcode._100_199;

import java.util.*;

import com.sakuray.code.practice.leetcode.Tools;
import com.sakuray.code.practice.leetcode.Tools.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
	For example:
	Given binary tree [1,null,2,3],
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].
Note: Recursive solution is trivial, could you do it iteratively?
 */
public class _145_BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		System.out.println(postorderTraversal_dfs(Tools.buildTreeByArray(new Integer[] {1,null,2,3})));
	}
	
	public static List<Integer> postorderTraversal_dfs(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.addFirst(p.val);  // Reverse the process of preorder
	            p = p.right;             // Reverse the process of preorder
	        } else {
	            TreeNode node = stack.pop();
	            p = node.left;           // Reverse the process of preorder
	        }
	    }
		return result;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) recursive(root, result);
        return result;
    }
	
	public static void recursive(TreeNode root, List<Integer> list) {
		if(root.left != null) recursive(root.left, list);
		if(root.right != null) recursive(root.right, list);
		list.add(root.val);
	}
	
	private static List<Integer> result;
    public List<Integer> postorderTraversal_S(TreeNode root) {
        result=new ArrayList<Integer>();
        inOrderRec(root);
        return result;
    }
    public void inOrderRec(TreeNode root){
        if(root!=null){
            inOrderRec(root.left);
            inOrderRec(root.right);
            result.add(root.val);
        }
    }
}
