package com.sakuray.code.practice.leetcode._800_899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
 * meaning there is an edge from node i to each node in graph[i].
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 * <p>
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
 * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 * <p>
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 */
public class _802_FindEventualSafeStates {

    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{5},
                new int[]{0},
                new int[]{5},
                new int[]{},
                new int[]{}
        }));

        System.out.println(eventualSafeNodes(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{0, 4},
                new int[]{}
        }));
    }

    /**
     * 找到安全节点，终止节点或者节点的所有路径都能通向终止节点
     * 先构建子节点，找到终止节点
     * 再进行广度优先遍历，判断每个节点是否是safe节点
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> childMap = new HashMap<>();
        Map<Integer, Boolean> safeNodeMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            int[] child = graph[i];
            if (child != null && child.length > 0) {
                childMap.put(i, Arrays.stream(child).boxed().collect(Collectors.toList()));
            } else {
                safeNodeMap.put(i, Boolean.TRUE);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (isSafeNode(i, safeNodeMap, childMap, new HashSet<>())) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSafeNode(int i, Map<Integer, Boolean> safeNodeMap, Map<Integer, List<Integer>> childMap,
                                      Set<Integer> pathNodeSet) {
        if (pathNodeSet.contains(i)) {
            safeNodeMap.put(i, false);
            return false;
        }
        pathNodeSet.add(i);
        Boolean result = safeNodeMap.get(i);
        if (result != null) {
            return result;
        }
        List<Integer> child = childMap.get(i);
        if (child == null || child.isEmpty()) {
            safeNodeMap.put(i, true);
            return true;
        }
        result = true;
        for (int c : child) {
            Set<Integer> newPath = new HashSet<>(pathNodeSet);
            result &= isSafeNode(c, safeNodeMap, childMap, newPath);
        }
        safeNodeMap.put(i, result);
        return result;
    }


    public List<Integer> eventualSafeNodes_S(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        int[] unsafe = new int[n];
        for (int i = 0; i < n; i++) {
            if (unsafe[i] == 0) {
                visited[i] = true;
                dfs(i, visited, graph, unsafe);
                visited[i] = false;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < unsafe.length; i++) {
            if (unsafe[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean dfs(int node, boolean[] visited, int[][] graph, int[] unsafe) {
        boolean isSafe = true;
        for (int neighbor : graph[node]) {

            if (visited[neighbor] || unsafe[neighbor] == 2) {
                isSafe = false;
                break;
            }
            if (unsafe[neighbor] == 1) {
                continue;
            }
            visited[neighbor] = true;
            if (!dfs(neighbor, visited, graph, unsafe)) {
                isSafe = false;
            }
            visited[neighbor] = false;
        }
        unsafe[node] = isSafe ? 1 : 2;
        return isSafe;
    }
}
