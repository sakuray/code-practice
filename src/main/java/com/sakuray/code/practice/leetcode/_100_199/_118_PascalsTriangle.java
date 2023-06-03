package com.sakuray.code.practice.leetcode._100_199;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * n Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class _118_PascalsTriangle {


    public static void main(String[] args) {
        generate(1);
        generate(2);
        generate(5);
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            if (i > 0) {
                List<Integer> last = results.get(i - 1);
                for (int j = 0; j < last.size() - 1; j++) {
                    row.add(last.get(j) + last.get(j+1));
                }
                row.add(1);
            }
            results.add(row);
        }
        return results;
    }
}
