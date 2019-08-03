package com.fogfore.leetcode.l5;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 课程表
 */
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 1 || numCourses < 1) return true;
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
        }
        // 入度为0进队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.addLast(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            count++;
            for (int[] p : prerequisites) {
                if (p[1] == course) {
                    indegree[p[0]]--;
                    if (indegree[p[0]] == 0) queue.addLast(p[0]);
                }
            }
        }
        return count == numCourses;
    }
}
