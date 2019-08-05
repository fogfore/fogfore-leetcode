package com.fogfore.leetcode.l5;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 */
public class LeetCode236 {
    private TreeNode res = null;

    // 递归
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + mid >= 2) {
            res = root;
            return true;
        }
        return left + right + mid > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        LinkedList<TreeNode> pl = new LinkedList<>();
//        LinkedList<TreeNode> ql = new LinkedList<>();
//        getPath(root, p, pl);
//        getPath(root, q, ql);
//        TreeNode res = null;
//        while (!pl.isEmpty() && !ql.isEmpty()) {
//            if (pl.peekFirst() == ql.peekFirst()) {
//                res = pl.removeFirst();
//                ql.removeFirst();
//            } else {
//                break;
//            }
//        }
//        return res;
//    }
//
//    private boolean getPath(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
//        if (root == null) return false;
//        path.addLast(root);
//        if (root.val == target.val) return true;
//        boolean res = getPath(root.left, target, path) || getPath(root.right, target, path);
//        if (!res) path.removeLast();
//        return res;
//    }
}
