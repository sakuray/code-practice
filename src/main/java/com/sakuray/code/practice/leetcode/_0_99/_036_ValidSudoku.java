package com.sakuray.code.practice.leetcode._0_99;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 */
public class _036_ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        }));

        System.out.println(isValidSudoku(new char[][]{
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        }));

    }

    // 不需要判断是否有解
    public static boolean isValidSudoku(char[][] board) {
//        Set<String> hashSet = new HashSet<>();
//        for(int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                char data = board[i][j];
//                if (data == '.') continue;
//                if (!hashSet.add(data + "row" + i)) return false;
//                if (!hashSet.add(data + "column" + j)) return false;
//                if (!hashSet.add(data + "cube" + i/3 + "-" + j/3)) return false;
//            }
//        }
//        return true;
        int[] rows = new int[board.length];
        int[] cols = new int[board[0].length];
        int[][] grid = new int[3][3];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != '.'){
                    int val = board[i][j] - '0';
                    if((rows[i] & (1 << val)) == 0 &&
                            (cols[j] & (1 << val)) == 0 &&
                            (grid[i/3][j/3] & (1 << val)) == 0){
                        rows[i] |= (1 << val);
                        cols[j] |= (1 << val);
                        grid[i/3][j/3] |= (1 << val);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
