package com.fogfore.leetcode.l5;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.LinkedList;

/**
 * 翻转二叉树
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
