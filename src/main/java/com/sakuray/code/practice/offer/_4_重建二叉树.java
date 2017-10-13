package com.sakuray.code.practice.offer;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。 
 * 前序遍历：中左右  
 * 中序遍历：左中右 
 * 后序遍历：左右中
 */
public class _4_重建二叉树 {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		System.out.println(reConstructBinaryTree(pre, in));
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length || pre.length == 0)
			return null;
		TreeNode root = new TreeNode(pre[0]); // 根节点
		int rootIndex = -1;
		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				rootIndex = i;
			}
		}
		if (rootIndex == -1)
			throw new RuntimeException("所给数据无法构成树:" + pre[0]);
		if (rootIndex != 0) { // 构建左子树
			int[] leftPre = new int[rootIndex];
			int[] leftIn = new int[rootIndex];
			for (int i = 0; i < rootIndex; i++) {
				leftPre[i] = pre[i + 1];
				leftIn[i] = in[i];
			}
			root.left = reConstructBinaryTree(leftPre, leftIn);
		}
		if (rootIndex != pre.length - 1) { // 构建右子树
			int[] rightPre = new int[pre.length - 1 - rootIndex];
			int[] rightIn = new int[pre.length - 1 - rootIndex];
			for (int i = 0; i < pre.length - 1 - rootIndex; i++) {
				rightPre[i] = pre[rootIndex + 1 + i];
				rightIn[i] = in[rootIndex +1 + i];
			}
			root.right = reConstructBinaryTree(rightPre, rightIn);
		}
		return root;
	}
	
	// 最佳答案
	public TreeNode reConstructBinaryTree_S(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}
	
	public TreeNode preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,HashMap<Integer,Integer> map){
        if(pi>pj){
            return null;
        }
        TreeNode head=new TreeNode(p[pi]);
        int index=map.get(p[pi]);
        head.left=preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right=preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }
}

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "val=" + val + ", left=[" + left + "], right=[" + right + "]";
	}
}