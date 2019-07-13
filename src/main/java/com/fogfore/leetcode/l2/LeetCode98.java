package com.fogfore.leetcode.l2;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.ArrayList;

/**
 * 验证二叉搜索树
 *
 * @author fogfore
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        return inOrder(root, list);
    }

    private static boolean inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return true;
        if (!inOrder(root.left, list)) return false;
        if (!list.isEmpty() && root.val <= list.remove(0)) {
            return false;
        }
        list.add(root.val);
        return inOrder(root.right, list);
    }
}
