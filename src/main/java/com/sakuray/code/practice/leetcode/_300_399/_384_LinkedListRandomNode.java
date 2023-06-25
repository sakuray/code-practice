package com.sakuray.code.practice.leetcode._300_399;

import java.util.Random;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * Implement the Solution class:
 * Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
 * int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 * <p>
 * Input
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * Output
 * [null, 1, 3, 2, 2, 3]
 * <p>
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // return 1
 * solution.getRandom(); // return 3
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 3
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 */
public class _384_LinkedListRandomNode {

    private ListNode node;
    private ListNode head;

    private int size;

    private void solve(ListNode head) {
        this.node = head;
        this.head = head;
        size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
    }

    /**
     * 未通过：
     * 水塘抽样算法，链表大小未知，需要均匀随机，每个节点被选中概率是1/n
     * 遍历到i个节点时，如果其概率是1/i，则认为均匀随机
     */
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(size);
        ListNode node = head;
        while (i > 0) {
            node = node.next;
            i--;
        }
        return node.val;
//        Random random = new Random();
//        int i = 0, res = 0;
//        if (node == null) {
//            node = head;
//        }
//        while (node != null) {
//            i++;
//            // 生成一个 [0, i) 之间的整数
//            // 这个整数等于 0 的概率就是 1/i
//            if (0 == random.nextInt(i)) {
//                res = node.val;
//            }
//            node = node.next;
//        }
//        return res;
    }
}
