package com.sakuray.code.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tools {

	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "[" + val + (left != null ? ",l="+left : "") + (right != null ? ",r=" + right:"")+"]";
		}
	}
	
	/**
	 * [1,2,3]		[1,null,2,2]
	 *    1				1
	 *   / \			 \
	 *  2   3		      2
	 *  				 /
	 *  				2
	 * 广度优先搜索BFS
	 * @param array
	 * @return
	 */
	public static TreeNode buildTreeByArray(Integer[] array) {
		if(array == null || array.length == 0) return null;
		TreeNode head = new TreeNode(array[0]);
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(head);
		int index = 1;
		while(!queue.isEmpty() && index < array.length) {
			TreeNode parent = queue.poll();
			if(array[index] != null) parent.left = new TreeNode(array[index]);
			index++;
			if(index < array.length && array[index] != null) parent.right = new TreeNode(array[index]);
			index++;
			if(parent.left != null) queue.add(parent.left);
			if(parent.right != null) queue.add(parent.right);
		}
		return head;
	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
		@Override
		public String toString() {
			return val + (next == null ? "" : "->" + next);
		}
	}
	
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
}
