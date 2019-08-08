package com.fogfore.leetcode.l7;

import com.fogfore.algorithm.utils.TreeFactory;
import com.fogfore.algorithm.utils.TreeNode;

import java.util.HashMap;

/**
 * 打家劫舍 III
 */
public class LeetCode337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        HashMap<TreeNode, Integer> has = new HashMap<>();
        HashMap<TreeNode, Integer> no = new HashMap<>();
        return Math.max(rob(root, true, has, no), rob(root, false, has, no));
    }

    private int rob(TreeNode root, boolean hasRoot, HashMap<TreeNode, Integer> has, HashMap<TreeNode, Integer> no) {
        if (root == null) return 0;
        if (!no.containsKey(root.left)) {
            no.put(root.left, rob(root.left, false, has, no));
        }
        if (!no.containsKey(root.right)) {
            no.put(root.right, rob(root.right, false, has, no));
        }
        if (!has.containsKey(root.left)) {
            has.put(root.left, rob(root.left, true, has, no));
        }
        if (!has.containsKey(root.right)) {
            has.put(root.right, rob(root.right, true, has, no));
        }
        if (hasRoot) {
            int total = root.val;
            total += no.get(root.left) + no.get(root.right);
            return total;
        } else {
            return Math.max(has.get(root.left), no.get(root.left)) + Math.max(has.get(root.right), no.get(root.right));
        }
    }

    public static void main(String[] args) {
        LeetCode337 l = new LeetCode337();
        TreeNode root = TreeFactory.buildTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        TreeNode root1 = TreeFactory.buildTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        System.out.println(l.rob(root));
        System.out.println(l.rob(root1));
    }
}
