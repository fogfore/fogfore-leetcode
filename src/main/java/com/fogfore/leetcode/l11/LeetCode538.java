package com.fogfore.leetcode.l11;

import com.fogfore.algorithm.utils.TreeFactory;
import com.fogfore.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 把二叉搜索树转换为累加树
 */
public class LeetCode538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        inorder(root, 0);
        return root;
    }

    private int inorder(TreeNode root, int sum) {
        if (root == null) return sum;
        sum = inorder(root.right, sum);
        root.val += sum;
        sum = root.val;
        return inorder(root.left, sum);
    }

    public static void main(String[] args) {
        LeetCode538 l = new LeetCode538();
        TreeNode root = TreeFactory.buildTree(new Integer[]{2, 0, 3, -4, 1});
        l.convertBST(root);
        System.out.println();
    }
}
