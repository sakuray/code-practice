package com.sakuray.code.practice.leetcode._0_99;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively. 
 * 
 * Example: Input: 4
		Output: [
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class _051_NQueens {

	public static void main(String[] args) {
		printArrays(solveNQueens(0), false);
		printArrays(solveNQueens(1), false);
		printArrays(solveNQueens(2), false);
		printArrays(solveNQueens(3), false);
		printArrays(solveNQueens(4), false);
		printArrays(solveNQueens(5), false);
	}
	
	/**
	 * N皇后问题，横竖斜都不能放子
	 */
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<Integer> record = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			putLine(n, 0, i, new ArrayList<>(n), result);
			if(record.size() == 1) record.remove(0);
		}
        return result;
    }
	
	/**
	 * 一行行放置皇后
	 * @param n			总行数
	 * @param line		当前行
	 * @param index		当前放置的位置
	 * @param record	之前放置位置的记录int[2]:0行号 1列号
	 * @param result	最终符合条件的结果
	 */
	public static void putLine(int n, int line, int index, List<Integer> record, List<List<String>> result) {
		// 判断是否能放在这个位置,如果不能不处理,通过循环找下一个能的点
		if(canInsert(line, index, record)) {
			if(record.size() == n) {
				generate(record, result);
			} else {
				for(int i = 0; i < n; i++) {
					putLine(n, line+1, i, record, result);
					if(record.size() == line+2) record.remove(line+1);	// 如果上一轮放置成功，移除
				}
			}
		}
	}
	
	public static boolean canInsert(int line, int index, List<Integer> record) {
		for(int i = 0, size = record.size(); i < size; i++) {
			int r = record.get(i);
			if(r == index || Math.abs(line - i) == Math.abs(index - r)) return false;
		}
		record.add(index);
		return true;
	}
	
	public static void generate(List<Integer> record, List<List<String>> result) {
		int n = record.size();
		List<String> one = new ArrayList<>(n);
		StringBuilder line = new StringBuilder(n);
		for(int i = 0; i < n; i++) {
			int col = record.get(i);
			for(int j = 0; j < n; j++) {
				if(col == j) {
					line.append("Q");
				} else {
					line.append(".");
				}
			}
			one.add(line.toString());
			line = new StringBuilder(n);
		}
		result.add(one);
	}
	
	@SuppressWarnings("rawtypes")
	private static void printArrays(List result, boolean print) {
		if(!print) return;
		System.out.print("[");
		for(int i = 0; i < result.size(); i++) {
			if(result.get(i) instanceof List) {
				printArrays((List)result.get(i), print);
			} else {
				System.out.print(result.get(i));
				System.out.println();
			}
			
		}
		System.out.print("]");
	}
	
	public List<List<String>> solveNQueens_S(int n) {
		List<List<String>> out = new ArrayList<>();
		
		String[] s = new String[n];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n-1;i++)
			sb.append('.');
		for(int i=0;i<n;i++)
			s[i] = new StringBuilder(sb).insert(i, 'Q').toString();
	
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
			nums[i] = i;
		
//		for(String d:s)
//			System.out.println(d);
		boolean[] v = new boolean[n];
		boolean[] fs = new boolean[n*2-1];
		boolean[] bs = new boolean[n*2-1];
		
		func(s,out,nums,0,v,fs,bs);
		
		
		return out;
	}
	
	/**
	 * 逐行放置皇后：
	 * v[i] 判断列是否冲突
	 *	/	(x1,y1) (x1-n,y1+n) 此种情况通过x1+y1=x1-n+y1+n来判断左斜情况  fs[i+b]
	 *	\	(x1,y1) (x1+n,y1+n) 此种情况通过x1-y1=x1+n-y1-n来判断右斜情况  由于x1-y1<=len-1 所以最后通过bs[len-1-b+i]来判断
	 */
	public void func(String[] sQ, List<List<String>> out, int[] n, int b, boolean[] v, boolean[] fs, boolean[] bs){
		int len = n.length;
		if(len==b){
//			System.out.println(Arrays.toString(n));
			
			List<String> temp = new ArrayList<>();
			
			for(int i=0;i<len;i++){
				temp.add(sQ[n[i]]);
			}
			
			out.add(temp);
			
			return;
		}
		
		for(int i = 0; i<len; i++){
//			System.out.println("b:"+b+" i:"+i+"  "+  (v[i] || fs[i+b] || bs[len-1-b+i]));
			
			if(v[i] || fs[i+b] || bs[len-1-b+i])continue;
			
			v[i] = true;
			fs[i+b] = true;
			bs[len-1-b+i] = true;
			n[b] = i;
			func(sQ, out, n, b+1, v, fs, bs);
			v[i] = false;
			fs[i+b] = false;
			bs[len-1-b+i] = false;
		}
	}
}
