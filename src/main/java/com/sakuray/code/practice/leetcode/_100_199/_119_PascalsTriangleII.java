package com.sakuray.code.practice.leetcode._100_199;

import com.sakuray.code.practice.leetcode.PrintTools;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangleII {

    public static void main(String[] args) {
        PrintTools.printList(getRow(0));
        PrintTools.printList(getRow(1));
        PrintTools.printList(getRow(2));
        PrintTools.printList(getRow(4));
        PrintTools.printList(getRow(33));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        int[][] records = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(getNum(rowIndex, i, records));
        }
        return result;
    }


    private static int getNum(int l, int index, int[][] records) {
        if (l < 0 || index < 0 || index > l) return 0;
        if (records[l][index] != 0) return records[l][index];
        if (l == index || index == 0) {
            records[l][index] = 1;
            return 1;
        }
        records[l - 1][index] = getNum(l - 1, index, records);
        records[l - 1][index - 1] = getNum(l - 1, index - 1, records);
        return  records[l - 1][index] + records[l - 1][index - 1];
    }
}
