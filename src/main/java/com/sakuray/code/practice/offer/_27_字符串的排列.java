package com.sakuray.code.practice.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 *      输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class _27_字符串的排列 {


    public static void main(String[] args) {
        System.out.println(Permutation("abca"));
    }

    // 递归求解，一个个确定
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0) return result;
        TreeSet<String> treeSet = new TreeSet<>();
        getResult(str.toCharArray(), 0, treeSet);
        result.addAll(treeSet);
        return result;
    }

    public static void getResult(char[] str, int start, TreeSet<String> treeSet) {
        if(start == str.length) {
            treeSet.add(String.valueOf(str));
        } else {
            for(int i = start; i < str.length; i++) {
                swap(str, start, i);
                getResult(str, start+1, treeSet);
                swap(str, i, start);
            }
        }
    }

    public static void swap(char[] str, int i, int j) {
        if(i != j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }

    public ArrayList<String> Permutation_S(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swapS(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swapS(cs, i, j);
            }
        }
    }

    public void swapS(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
