package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 对称二叉树
 *
 * @author fogfore
 */
public class LeetCode101 {
    // 迭代
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root.left);
        queue.addFirst(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.removeFirst();
            TreeNode node2 = queue.removeFirst();
            if (node1 == null && node2 == null) continue;
            if (!(node1 != null && node2 != null && node1.val == node2.val)) return false;
            queue.addFirst(node1.left);
            queue.addFirst(node2.right);
            queue.addFirst(node1.right);
            queue.addFirst(node2.left);
        }
        return true;
    }

    // 递归
//    public boolean isSymmetric(TreeNode root) {
//        return root == null || isMirror(root.left, root.right);
//    }
//
//    private boolean isMirror(TreeNode left, TreeNode right) {
//        if (left == null && right == null) return true;
//        if (left == null || right == null) return false;
//        return (left.val == right.val) &&
//                isMirror(left.left, right.right) &&
//                isMirror(left.right, right.left);
//    }
}
