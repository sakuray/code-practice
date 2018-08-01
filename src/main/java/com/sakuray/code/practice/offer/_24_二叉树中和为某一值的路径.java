package com.sakuray.code.practice.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class _24_二叉树中和为某一值的路径 {

    /**
     * 深度优先搜索
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        TreeMap<Integer, ArrayList<ArrayList<Integer>>> treeMap = new TreeMap<>(Collections.reverseOrder());
        search(root, 1, treeMap, target, new ArrayList<>());
        for(Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry : treeMap.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    public void search(TreeNode root, int depth, TreeMap<Integer, ArrayList<ArrayList<Integer>>> treeMap, int target, ArrayList<Integer> list) {
        list.add(root.val);
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null) {   // 找到一条路径
            ArrayList tmp = treeMap.get(depth);
            if(tmp == null) {
                tmp = new ArrayList();
                treeMap.put(depth, tmp);
            }
            tmp.add(list);
            return;
        }
        if(root.left != null) {
            search(root.left, depth+1, treeMap, target, (ArrayList<Integer>) list.clone());
        }
        if(root.right != null) {
            search(root.right, depth+1, treeMap, target, (ArrayList<Integer>) list.clone());
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath_S(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return arr;
        ArrayList<Integer> a1=new ArrayList<Integer>();
        int sum=0;
        pa(root,target,arr,a1,sum);
        return arr;
    }

    public void pa(TreeNode root,int target,ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1,int sum){
        if(root==null)
            return ;
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==target)
            { a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size()-1);

            }
            return ;

        }
        a1.add(root.val);
        pa(root.left,target,arr,a1,sum);
        pa(root.right,target,arr,a1,sum);
        a1.remove(a1.size()-1);
    }
}
