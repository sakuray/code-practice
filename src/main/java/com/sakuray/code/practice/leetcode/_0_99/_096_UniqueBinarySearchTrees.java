package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example, Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class _096_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
	
	/**
	 * BST：二叉搜索树，不需要平衡，左边比父节点小，右边比父节点大。左右子树也是二叉搜索树
	 * G(n)为目标函数，设F(i,n)是i作为树的root节点计算的结果数，则
	 * G(n)=F(1,n)+F(2,n)+...+F(n,n)
	 * 根据假设，易知G(0)=G(1)=1
	 * F(i,n) 1<=i<=n  i的左边都比i小，所以左边构成左子树,同理右边构成右子树
	 * 左右子树都是二叉搜索树，则F(i,n)=G(i-1)*G(n-i)
	 * 最终式子如下：
	 * G(n)=F(1,n)+F(2,n)+...+F(n,n)
	 * F(i,n)=G(i-1)*G(n-i)
	 * G(0)=G(1)=1
	 */
	public static int numTrees(int n) {
		int[] result = new int[n+1];
		result[0]=result[1]=1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				result[i] += result[j-1]*result[i-j];
			}
		}
        return result[n];
    }
	
	public int numTrees_S(int n) {
        if(n <= 0) return 0;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
