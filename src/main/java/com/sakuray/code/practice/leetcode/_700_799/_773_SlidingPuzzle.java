package com.sakuray.code.practice.leetcode._700_799;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import com.sakuray.code.practice.leetcode.Tools;

/**
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * <p>
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * <p>
 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 * <p>
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * <p>
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * <p>
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 */
public class _773_SlidingPuzzle {

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(Tools.build2Array(3, 1,2,3,4,0,5)));
    }

    /**
     * 类似华容道，仅0可以移动，找到指定顺序，最少需要移动多少步
     * BFS搜索：
     * 1.找到当前0可以移动的方向
     */
    public static int slidingPuzzle(int[][] board) {
        // 2 * 3的格子，
        int[][] neighbors = new int[][]{
                new int[]{1, 3},
                new int[]{0, 2, 4},
                new int[]{1, 5},
                new int[]{0, 4},
                new int[]{1, 3, 5},
                new int[]{2, 4}
        };
        String target = "123450";
        StringBuilder now = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                now.append(board[i][j]);
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(now.toString());
        Set<String> visited = new HashSet<>();
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return result;
                }
                if (visited.contains(poll)) {
                    continue;
                }
                visited.add(poll);
                int index = 0;
                for (; poll.charAt(index) != '0'; index++) {
                }
                int[] neighbor = neighbors[index];
                for (int n : neighbor) {
                    String swap = swap(index, n, poll);
                    queue.add(swap);
                }
            }
            result++;
        }
        return -1;
    }

    private static String swap(int a, int b, String str) {
        char[] chars = str.toCharArray();
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
        return new String(chars);
    }
}
