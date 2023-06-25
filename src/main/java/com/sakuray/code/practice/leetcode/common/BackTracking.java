package com.sakuray.code.practice.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法解析：https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-c26da/
 * 类似DFS深度优先搜索，本质是暴力穷举法。差别在于：
 * 回溯法遍历的是树枝(路径，有多少种组合路径)，DFS遍历的是节点
 * 场景：1.排列组合：给一组数字，求有多少种排列组合方式
 * 题目：46、51、52
 */
public class BackTracking {

    /**
     * 回溯法的关键有3个内容：当前路径，可选列表，结束条件
     *
     * @param nums 可选列表，注意这里是全部内容，需要判断是否选择过
     */
    private void getResult(int[] nums, List<Integer> curResult, List<List<Integer>> result) {
        if (curResult.size() == nums.length) {
            // 终止条件：可选列表全部选择了
            result.add(new ArrayList<>(curResult));
        } else {
            // 遍历可选列表
            for (int num : nums) {
                if (!curResult.contains(num)) {
                    // 添加可选列表
                    curResult.add(num);
                    // 继续遍历路径
                    getResult(nums, curResult, result);
                    // 移除可选列表，进行回溯
                    curResult.remove(num);
                }
            }
        }
    }
}
