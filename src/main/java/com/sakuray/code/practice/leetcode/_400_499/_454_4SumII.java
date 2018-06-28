package com.sakuray.code.practice.leetcode._400_499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * 
 * Example:

	Input:
	A = [ 1, 2]
	B = [-2,-1]
	C = [-1, 2]
	D = [ 0, 2]
	
	Output:
	2
	
   Explanation:
	The two tuples are:
	1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
	2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class _454_4SumII {
	
	public static void main(String[] args) {
		System.out.println(fourSumCount(new int[] {1, 2}, new int[] {-2,-1}, new int[] {-1, 2}, new int[] {0, 2}));
	}
	
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> ab = new HashMap<>();
		Integer cur = null;
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B.length; j++) {
				cur = A[i] + B[j];
				ab.put(cur, ab.getOrDefault(cur, 0) + 1);
			}
		}
		int count = 0;
		for(int i = 0; i < C.length; i++) {
			for(int j = 0; j < D.length; j++) {
				count += ab.getOrDefault(0 - C[i] - D[j], 0);
			}
		}
        return count;
    }
	
	public int fourSumCount_S(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        int[] temp1 =  new int[A.length * B.length];
        int[] temp2 = new int[C.length * D.length];
        int trav1 = 0;
        int trav2 = 0;
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < B.length;j++){
                temp1[trav1++] = A[i] + B[j]; 
            }
        }
        for(int i = 0;i < C.length;i++){
            for(int j = 0;j < D.length;j++){
                temp2[trav2++] = C[i] + D[j]; 
            }
        }
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        cnt += twosum(temp1,temp2,0);
        return cnt;
    }
    private int twosum(int[] A,int[] B,int target){
        int lo = 0;
        int hi = A.length - 1;
        int cnt = 0;
        int cntA = 1;
        int cntB = 1;
        while(true){
            if((lo == A.length) || hi == -1){
                break;
            }
            if(A[lo] + B[hi] == target){
                while(lo <= A.length - 2 && A[lo] == A[lo+1]){
                    lo++;
                    cntA++;
                }
                while(hi >= 1 && B[hi] == B[hi-1]){
                    hi--;
                    cntB++;
                }
                cnt += cntA * cntB;
                lo++;
                hi--;
                cntA = 1;
                cntB = 1;
            }else if(A[lo] + B[hi] < target){
                lo++;
            }else{
                hi--;
            }
        }
        return cnt;
    }
}
