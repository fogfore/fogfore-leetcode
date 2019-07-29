package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.TreeFactory;
import com.fogfore.algorithm.utils.TreeNode;

/**
 * 二叉树中的最大路径和
 */
public class LeetCode124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int cur = left + root.val + right;
        max = Math.max(cur, max);
        int res = Math.max(left, right) + root.val;
        return res < 0 ? 0 : res;
    }

    public static void main(String[] args) {
        TreeNode a = TreeFactory.buildTree(new Integer[]{1, 2, 3});
        TreeNode b = TreeFactory.buildTree(new Integer[]{-10, 9, 20, null, null, 15, 7});
        TreeNode c = TreeFactory.buildTree(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
        TreeNode d = TreeFactory.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        LeetCode124 l = new LeetCode124();
        System.out.println(l.maxPathSum(d));
        l = new LeetCode124();
        System.out.println(l.maxPathSum(c));
        l = new LeetCode124();
        System.out.println(l.maxPathSum(a));
        l = new LeetCode124();
        System.out.println(l.maxPathSum(b));
    }
}
