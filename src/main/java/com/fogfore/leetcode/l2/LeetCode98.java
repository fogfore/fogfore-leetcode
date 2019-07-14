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
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer higher) {
        if (root == null) return true;
        TreeNode left = root.left, right = root.right;
        if (left != null && (left.val >= root.val || (lower != null && left.val <= lower))) return false;
        if (right != null && (right.val <= root.val || (higher != null && right.val >= higher))) return false;

        return isValidBST(left, lower, root.val) && isValidBST(right, root.val, higher);
    }

    // 中序遍历
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        ArrayList<Integer> list = new ArrayList<>();
//        return inOrder(root, list);
//    }
//
//    private static boolean inOrder(TreeNode root, ArrayList<Integer> list) {
//        if (root == null) return true;
//        if (!inOrder(root.left, list)) return false;
//        if (!list.isEmpty() && root.val <= list.remove(0)) {
//            return false;
//        }
//        list.add(root.val);
//        return inOrder(root.right, list);
//    }
}
