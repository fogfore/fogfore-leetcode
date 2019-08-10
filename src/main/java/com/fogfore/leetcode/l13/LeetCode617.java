package com.fogfore.leetcode.l13;

import com.fogfore.algorithm.utils.TreeNode;

/**
 * 合并二叉树
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 != null) {
            if (t2 != null) {
                t1.val += t2.val;
                t1.left = mergeTrees(t1.left, t2.left);
                t1.right = mergeTrees(t1.right, t2.right);
            }
            return t1;
        } else {
            return t2;
        }
    }
}
