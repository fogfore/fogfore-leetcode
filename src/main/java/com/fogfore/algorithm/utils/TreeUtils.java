package com.fogfore.algorithm.utils;


import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.StringJoiner;

public class TreeUtils {
    private static final ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static String toStringByInOrder(TreeNode root) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        toStringByInOrder(root, joiner);
        return joiner.toString();
    }

    public static void fillByInOrder(TreeNode root, List<Integer> values) {
        if (ObjectUtils.isEmpty(root)) {
            return;
        }
        fillByInOrder(root.left, values);
        root.val = values.remove(0);
        fillByInOrder(root.right, values);
    }

    public static int getDepth(TreeNode root) {
        if (ObjectUtils.isEmpty(root)) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return leftDepth > rightDepth ? rightDepth + 1 : rightDepth + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }

    private static boolean isBalanced(TreeNode root, int[] depth) {
        if (ObjectUtils.isEmpty(root)) {
            depth[0] = 0;
            return true;
        }
        int[] leftDepth = new int[1];
        int[] rightDepth = new int[1];
        if (isBalanced(root.left, leftDepth) && isBalanced(root.right, rightDepth)) {
            int delta = leftDepth[0] - rightDepth[0];
            if (delta <= 1 && delta >= -1) {
                depth[0] = leftDepth[0] > rightDepth[0] ? leftDepth[0] + 1 : rightDepth[0] + 1;
                return true;
            }
        }
        return false;
    }

    private static void toStringByInOrder(TreeNode root, StringJoiner joiner) {
        if (ObjectUtils.isEmpty(root)) {
            return;
        }
        toStringByInOrder(root.left, joiner);
        joiner.add(String.valueOf(root.val));
        toStringByInOrder(root.right, joiner);
    }
}
