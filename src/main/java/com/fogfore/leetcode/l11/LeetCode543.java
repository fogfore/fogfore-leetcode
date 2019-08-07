package com.fogfore.leetcode.l11;

import com.fogfore.algorithm.utils.TreeNode;

/**
 * 二叉树的直径
 */
public class LeetCode543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return -1;
        int left = helper(root.left);
        int right = helper(root.right);
        left = left < 0 ? 0 : left + 1;
        right = right < 0 ? 0 : right + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
