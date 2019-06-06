package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author fogfore
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
