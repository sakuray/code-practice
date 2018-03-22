package com.sakuray.code.practice.leetcode;

/**
 * Given a list of positive integers, the adjacent integers will perform the float division. 
 * For example, [2,3,4] -> 2 / 3 / 4.
 * However, you can add any number of parenthesis at any position to change the priority of operations. 
 * You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. 
 * Your expression should NOT contain redundant parenthesis.
Example:
	Input: [1000,100,10,2]
	Output: "1000/(100/10/2)"
	Explanation:1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
since they don't influence the operation priority. So you should return "1000/(100/10/2)". 

Other cases:
	1000/(100/10)/2 = 50
	1000/(100/(10/2)) = 50
	1000/100/10/2 = 0.5
	1000/100/(10/2) = 2
Note:
	The length of the input array is [1, 10].
	Elements in the given array will be in range [2, 1000].
	There is only one optimal division for each test case.
 *
 */
public class _553_OptimalDivision {

	public static void main(String[] args) {
		System.out.println(optimalDivision(new int[] {1000,100,10,2}));
	}
	
	public static String optimalDivision(int[] nums) {
        if(nums == null || nums.length == 0) return "";
		if(nums.length == 1) return String.valueOf(nums[0]);
		if(nums.length == 2) return nums[0] + "/" + nums[1];
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
		sb.append("/(");
		sb.append(nums[1]);
		for(int i = 2; i < nums.length; i++) {
			sb.append("/");
			sb.append(nums[i]);
		}
		sb.append(")");
		return sb.toString();
    }
	
	public String optimalDivision_S(int[] nums) {
		// 日常防空
		if (nums == null || nums.length == 0) {
			return "";
		}
		// 思路：
		// 对于 A/B/C/.../N，不论括号怎么加，在最终表达式里，A一定位于分子，B一定位于分母，所以可表达为 (A/B)*X
		// 如果想要该值最大化，则 X 必须最大化，在该表达式中，最大的X为剩下所有数的乘积，MAX(X)=C*D*...*N
		// 所以最大值为 (A/B)*X = (A*C*D*...*N)/B = A*( (C*D*...*N)/B ) = A/( B/(C*D*...*N) )
		// = A/(B/C/D/.../N)
		// 所以直接使用括号把除了第一个数之外的其他数都括起来即可
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < nums.length; i++) {
			sb.append(nums[i]).append('/');
		}
		result.append(nums[0]);
		if (nums.length > 2) {
			result.append("/(").append(sb.substring(0, sb.length() - 1)).append(")");
		} else if (nums.length == 2) {
			result.append("/").append(sb.substring(0, sb.length() - 1));
		}

		return result.toString();
	}
	
	class T {
        float max_val, min_val;
        String min_str, max_str;
    }
    public String optimalDivision_A(int[] nums) {
        T[][] memo = new T[nums.length][nums.length];
        T t = optimal(nums, 0, nums.length - 1, "", memo);
        return t.max_str;
    }
    public T optimal(int[] nums, int start, int end, String res, T[][] memo) {
        if (memo[start][end] != null)
            return memo[start][end];
        T t = new T();
        if (start == end) {
            t.max_val = nums[start];
            t.min_val = nums[start];
            t.min_str = "" + nums[start];
            t.max_str = "" + nums[start];
            memo[start][end] = t;
            return t;
        }
        t.min_val = Float.MAX_VALUE;
        t.max_val = Float.MIN_VALUE;
        t.min_str = t.max_str = "";
        for (int i = start; i < end; i++) {
            T left = optimal(nums, start, i, "", memo);
            T right = optimal(nums, i + 1, end, "", memo);
            if (t.min_val > left.min_val / right.max_val) {
                t.min_val = left.min_val / right.max_val;
                t.min_str = left.min_str + "/" + (i + 1 != end ? "(" : "") + right.max_str + (i + 1 != end ? ")" : "");
            }
            if (t.max_val < left.max_val / right.min_val) {
                t.max_val = left.max_val / right.min_val;
                t.max_str = left.max_str + "/" + (i + 1 != end ? "(" : "") + right.min_str + (i + 1 != end ? ")" : "");
            }
        }
        memo[start][end] = t;
        return t;
    }
}
