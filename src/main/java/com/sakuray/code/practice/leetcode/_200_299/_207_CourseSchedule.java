package com.sakuray.code.practice.leetcode._200_299;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class _207_CourseSchedule {

    /**
     * [a1,b1]，要学习a1，先要学习b1，判断是否可以上完全部的课程，简单来说，判断图中是否有环
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        boolean[] hasParent = new boolean[numCourses];
        for (int[] prerequisite : prerequisites) {
            parentMap.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
            hasParent[prerequisite[0]] = true;
        }
        Queue<Integer> topQueue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!hasParent[i]) {
                topQueue.add(i);
            }
        }
        int cnt = 0;
        while(!topQueue.isEmpty()) {
            Integer poll = topQueue.poll();
            cnt++;
            for (Map.Entry<Integer, List<Integer>> entry : parentMap.entrySet()) {
                List<Integer> inDegree = entry.getValue();
                boolean remove = inDegree.remove(poll);
                if (remove && inDegree.isEmpty()) {
                    topQueue.add(entry.getKey());
                }
            }
        }
        return cnt == numCourses;
    }

    public boolean canFinish_S(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            cnt++;
            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}
