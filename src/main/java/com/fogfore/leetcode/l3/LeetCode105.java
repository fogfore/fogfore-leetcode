package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author fogfre
 */
public class LeetCode105 {
    int pre_idx = 0;
    int[] preOrder = null;
    int[] inOrder = null;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length < 1 || inorder.length < 1) return null;
        int idx = 0;
        for (int v : inorder) {
            map.put(v, idx++);
        }
        this.preOrder = preorder;
        this.inOrder = inorder;
        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preOrder[pre_idx]);
        Integer mid = map.get(preOrder[pre_idx]);
        pre_idx++;
        root.left = buildTree(left, mid - 1);
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
