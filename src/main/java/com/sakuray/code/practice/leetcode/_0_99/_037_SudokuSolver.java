package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class _037_SudokuSolver {

    public static void main(String[] args) {
        char[][] chars = {
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(chars);
        PrintTools.print2Array(chars);
    }

    /**
     * 给出数独的一个解，暴力穷举：回溯法
     */
    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                backtrack(board, i, j);
            }
        }
    }

    private static boolean backtrack(char[][] board, int x, int y) {
        if (y == 9) {
            return backtrack(board, x + 1, 0);
        }
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') {
            return backtrack(board, x, y + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, x, y, ch)) {
                continue;
            }
            board[x][y] = ch;
            if (backtrack(board, x, y + 1)) {
                return true;
            }
            board[x][y] = '.';
        }
        return false;
    }

    private static boolean isValid(char[][] board, int x, int y, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == ch) {
                return false;
            }
            if (board[i][y] == ch) {
                return false;
            }
            if (board[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}
