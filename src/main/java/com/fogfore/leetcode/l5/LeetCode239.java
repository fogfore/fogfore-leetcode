package com.fogfore.leetcode.l5;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (i - queue.peekFirst() >= k) queue.removeFirst();
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}
