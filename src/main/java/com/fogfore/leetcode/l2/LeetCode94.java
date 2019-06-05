package com.fogfore.leetcode.l2;

import com.fogfore.algorithm.utils.ListNode;
import com.fogfore.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author fogfore
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.peekFirst();
            while (node.left != null) {
                stack.addFirst(node.left);
                node = node.left;
            }
            res.add(node.val);
            stack.removeFirst();
            if (node.right != null) {
                stack.addFirst(node);
            }
        }
        return null;
    }
}
