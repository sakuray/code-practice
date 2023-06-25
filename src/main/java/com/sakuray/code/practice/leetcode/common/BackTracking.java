package com.sakuray.code.practice.leetcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 回溯法解析：
 * <a href="https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-c26da/"></a>
 * <a href="https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-56e11/"></a>
 * 类似DFS深度优先搜索，本质是暴力穷举法。差别在于：
 * 回溯法遍历的是树枝(路径，有多少种组合路径)，DFS遍历的是节点
 * 场景：排列/组合/子集  元素是否重复 × 元素是否可以重复选择，元素可重可复选，等同于元素不重可复选，所以有3类
 * 元素无重，不可复选：
 * a.78子集问题：获取数组的全部不重复的子集：关键在于增加start指针，可选列表不会从头开始遍历
 * b.77组合问题：1-N中选择k个数字进行组合，获得所有不同的组合：同子集问题，增加限制条件size = k
 * c.46全排列问题：获取数组的全排列：路径有序则每次需要从可选列表0开始遍历，标识可选列表元素是否被使用过
 * d.216组合问题：从1-9中选择k个数字组合的值等于target：同77终止条件是sum = target
 * 元素可重，不可复选
 * a.90子集问题：获取数组中全部不重复的子集，数组中存在重复元素：关键在于剪枝重复的路径，1，2，2'，(1,2)和(1,2')是一样的，先排序
 * b.47全排列问题：同46 + 90的做法，在固定位置的元素不能重复遍历，跳过相关子树即可
 * c.40子集问题：类似凑硬币，但是每个硬币只能选择一次，存在同面额的硬币，几乎等同于90，终止条件=target
 * 元素无重复，可复选：
 * a.39子集问题：同78，类似凑硬币金额，找到多少种方案，数组合为指定数值。关键在于元素可以重复选择，i+1改成继续遍历i，大于target不需要再遍历了
 * b.排列问题：39移除剪枝逻辑即可
 */
public class BackTracking {

    /**
     * 回溯法的关键有3个内容：当前路径，可选列表，结束条件
     * 回溯法优化可以配合备忘录模式，进行剪枝(前提有可以重复遍历的分支)
     *
     * @param nums 可选列表，注意这里是全部内容，需要判断是否选择过
     */
    private void getResult(int[] nums, List<Integer> curResult, List<List<Integer>> result, Map<String, Boolean> mem) {
        if (curResult.size() == nums.length) {
            // 终止条件：可选列表全部选择了
            result.add(new ArrayList<>(curResult));
        } else {
            // 遍历可选列表
            for (int num : nums) {
                if (!curResult.contains(num)) {
                    // 添加可选列表
                    curResult.add(num);
                    // 路径裁剪
//                    if (mem.containsKey(Arrays.toString(curResult))) {
//                        return mem.get(xxx);
//                    }
                    // 继续遍历路径
                    getResult(nums, curResult, result, mem);
                    // 备忘录记录状态及结果
//                    mem.put(Arrays.toString(curResult, getResult结果));
                    // 移除可选列表，进行回溯
                    curResult.remove(num);
                }
            }
        }
    }
}
