package com.fogfore.leetcode.l13;

import java.util.Arrays;

/**
 * 任务调度器
 */
public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] nums = new int[26];
        for (char c : tasks) {
            nums[c - 'A']++;
        }
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (count == num) {
                maxCount++;
            } else if (num > count) {
                count = num;
                maxCount = 1;
            }
        }
        return Math.max((count - 1) * (n + 1) + maxCount, tasks.length);
    }
}
