package com.sakuray.code.practice.leetcode._700_799;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * <p>
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
 * <p>
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation: We cannot reach the target without getting stuck.
 */
public class _752_OpenTheLock {

    /**
     * 每一次都可以对任何一位进行+1，-1，总共4位，8次
     * 遇到deadlock跳过，BFS搜索
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        int result = 0;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return result;
                }
                if (deadSet.contains(poll)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(j, poll);
                    if (!visited.contains(plusOne)) {
                        queue.add(plusOne);
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(j, poll);
                    if (!visited.contains(minusOne)) {
                        queue.add(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private String plusOne(int x, String target) {
        char[] data = target.toCharArray();
        if (data[x] == '9') {
            data[x] = '0';
        } else {
            data[x] += 1;
        }
        return new String(data);
    }

    private String minusOne(int x, String target) {
        char[] data = target.toCharArray();
        if (data[x] == '0') {
            data[x] = '9';
        } else {
            data[x] -= 1;
        }
        return new String(data);
    }
}
