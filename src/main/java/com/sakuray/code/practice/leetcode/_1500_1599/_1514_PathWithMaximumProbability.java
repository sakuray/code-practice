package com.sakuray.code.practice.leetcode._1500_1599;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b]
 * is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 * <p>
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * Output: 0.25000
 * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 * <p>
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * Output: 0.30000
 * <p>
 * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * Output: 0.00000
 * Explanation: There is no path between 0 and 2.
 */
public class _1514_PathWithMaximumProbability {

    /**
     * n个节点的图，边的关系存在edges中，succProb是成功概率(两个节点之间)
     * 给一个start节点和end节点，找到最大成功概率的路径，如果没有返回0
     * 图的广度优先搜索，概率在[0,1]之间，相乘会越来越小，所以边没有方向产生循环不要紧，循环回来一定比初始概率小
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> afterMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            afterMap.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], succProb[i]);
            afterMap.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], succProb[i]);
        }
        double[] prob = new double[n];
        prob[start] = 1.0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            Map<Integer, Double> afterPath = afterMap.get(curNode);
            if (afterPath != null && !afterPath.isEmpty()) {
                for (Map.Entry<Integer, Double> entry : afterPath.entrySet()) {
                    int after = entry.getKey();
                    double newProb = prob[curNode] * entry.getValue();
                    if (newProb > prob[after]) {
                        prob[after] = newProb;
                        queue.offer(after);
                    }
                }
            }
        }
        return prob[end];
    }
}
