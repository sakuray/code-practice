package com.sakuray.code.practice.leetcode.common;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * 广度优先搜索，使用队列，将同一层级的数据放入，然后遍历放入下一层级
 * 题目：
 * 111：找到树的最低深度
 * 752：最少转动次数解锁
 * 773：移格子，最少步骤符合预期排序
 */
public class BFS {

    private void bfs(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历同级内容
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 当前层级处理逻辑
                // 放入下一层级内容，因为队列的先进先出，我们提前计算了本层的节点数量
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }
}
