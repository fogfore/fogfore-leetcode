package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树展开为链表
 *
 * @author fogfore
 */
public class LeetCode114 {
    // 循环 将左子树的最右节点和右子树连接，将左子树移到右子树
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode p = cur.left;
                while (p.right != null) p = p.right;
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    // 递归，左子树的右节点和右子树连接，将根节点的左子树移到右子树
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        helper(root, null);
//    }
//
//    public TreeNode helper(TreeNode root, TreeNode pre) {
//        if (root == null) return pre;
//        pre = helper(root.right, pre);
//        pre = helper(root.left, pre);
//        root.right = pre;
//        root.left = null;
//        return root;
//    }

    // 先序遍历
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        flatten(root.left);
//        flatten(root.right);
//        if (root.left != null) {
//            TreeNode r = root.right;
//            root.right = root.left;
//            while (root.right != null) {
//                root.left = null;
//                root = root.right;
//            }
//            root.left = null;
//            root.right = r;
//        }
//    }

    // 先先序遍历，再把结果连起来
//    public void transfer(TreeNode root, List<TreeNode> list) {
//        if (root == null) return;
//        list.add(root);
//        transfer(root.left, list);
//        transfer(root.right, list);
//    }
//
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        LinkedList<TreeNode> list = new LinkedList<>();
//        transfer(root, list);
//        TreeNode r = new TreeNode(0);
//        for (TreeNode n : list) {
//            r.right = n;
//            n.left = null;
//            r = n;
//        }
//    }
}
