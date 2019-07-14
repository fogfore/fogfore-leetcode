package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历
 *
 * @author fogfore
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode rightest = root;
        List<Integer> line = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode r = queue.removeFirst();
            line.add(r.val);
            if (r.left != null) queue.addLast(r.left);
            if (r.right != null) queue.addLast(r.right);

            if (rightest != null && rightest == r) {
                res.add(line);
                line = new LinkedList<>();
                rightest = !queue.isEmpty() ? queue.getLast() : null;
            }
        }

        return res;
    }
}
