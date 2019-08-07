package com.fogfore.leetcode.l6;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 */
public class LeetCode297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return res.toString();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                res.addLast(null);
            } else {
                res.addLast(node.val);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        while (res.peekLast() == null) {
            res.removeLast();
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] strs = data.substring(1, data.length() - 1).split(", ");
        if (strs.length < 1) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int ops = 1;
        while (ops < strs.length) {
            TreeNode node = queue.removeFirst();
            if (!strs[ops].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strs[ops]));
                queue.addLast(node.left);
            }
            ops++;
            if (ops >= strs.length) break;
            if (!strs[ops].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strs[ops]));
                queue.addLast(node.right);
            }
            ops++;
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode297 l = new LeetCode297();
        TreeNode root = l.deserialize("[]");
        TreeNode root1 = l.deserialize("[1, 2, 3, null, null, 4, 5]");
        System.out.println(l.serialize(null));
    }
}
