package com.fogfore.leetcode.l9;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.LinkedList;

/**
 * 路径总和 III
 */
public class LeetCode437 {
    public int pathSum(TreeNode root, int sum) {
        return helper(root, sum, new LinkedList<>());
    }

    private int helper(TreeNode root, int sum, LinkedList<Integer> queue) {
        if (root == null) return 0;
        queue.addFirst(root.val);
        int s = 0;
        int count = 0;
        for (int v : queue) {
            s += v;
            if (s == sum) count++;
        }
        count += helper(root.left, sum, queue);
        count += helper(root.right, sum, queue);
        queue.removeFirst();
        return count;
    }
}
