package com.sakuray.code.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	For example,
		If n = 4 and k = 2, a solution is:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
	从1到n中选出k个数字进行组合
 *
 */
public class _077_Combinations {

	public static void main(String[] args) {
//		System.out.println(1 == combine(1, 1).size());
		System.out.println(6 == combine(4, 2).size());
//		System.out.println(10 == combine(5, 3).size());
//		System.out.println(5 == combine(5, 4).size());
//		System.out.println(1 == combine(5, 5).size());
//		System.out.println(0 == combine(5, 6).size());
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> one;
		for(int i = 1, end = n - k + 1; i <= end; i++) {
			one =  new ArrayList<>(1);
			one.add(i);
			result.add(one);
			combineByLast(i + 1, n, k - 1, result);
		}
        return result;
    }
	
	public static void combineByLast(int begin, int end, int k, List<List<Integer>> result) {
		if(k != 0) {
			int index = result.size() - 1;
			List<Integer> last = result.get(index);
			result.remove(index);
			List<Integer> one;
			for(int i = begin, e = end - k + 1; i <= e; i++) {
				one = new ArrayList<>(index + 1);
				one.addAll(last);
				one.add(i);
				result.add(one);
				combineByLast(i + 1, end, k - 1, result);
			}
		}
	}
	
	public List<List<Integer>> combine_S(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        combineHelper(1, n, k, list, resultList);
        return resultList;
    }
    
    public void combineHelper(int start, int n, int k, List<Integer> list, List<List<Integer>> resultList) {
        if ( k == 0 ) {
            // case #1
            resultList.add(new ArrayList<>(list));
            return;
        }
        if ( n - start + 1 < k ) {
            // case #2
            return;
        }
        // add start to list
        list.add(start);
        combineHelper(start + 1, n, k - 1, list, resultList);
        // remove start from list
        list.remove(list.size() - 1);
        combineHelper(start + 1, n, k, list, resultList);
    }
}
