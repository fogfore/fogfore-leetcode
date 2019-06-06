package com.fogfore.leetcode.l2;

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
//    List<Integer> res = new ArrayList<>();

    // 迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.peekFirst();
            while (node.left != null) {
                stack.addFirst(node.left);
                node = node.left;
            }
            while (!stack.isEmpty()) {
                node = stack.peekFirst();
                stack.removeFirst();
                res.add(node.val);
                if (node.right != null) {
                    stack.addFirst(node.right);
                    break;
                }
            }
        }
        return res;
    }

    // 递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root != null) {
//            inorderTraversal(root.left);
//            res.add(root.val);
//            inorderTraversal(root.right);
//        }
//        return res;
//    }

    public static void main(String[] args) {

    }
}
