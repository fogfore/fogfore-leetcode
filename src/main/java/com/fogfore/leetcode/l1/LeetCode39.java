package com.fogfore.leetcode.l1;

import java.util.*;

/**
 * 组合总和
 *
 * @author fogfore
 */
public class LeetCode39 {
    // 回溯法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        cal(candidates, target, 0, 0, queue, res);
        return res;
    }

    private void cal(int[] candidates, int target, int cur, int sum, LinkedList<Integer> queue, List<List<Integer>> res) {
        if (cur >= candidates.length) {
            return;
        }
        while (sum < target) {
            cal(candidates, target, cur + 1, sum, queue, res);
            sum += candidates[cur];
            queue.addFirst(candidates[cur]);
        }
        if (sum == target) {
            res.add(new LinkedList<>(queue));
        }
        while (!queue.isEmpty() && queue.peekFirst() == candidates[cur]) {
            queue.removeFirst();
        }
    }

    // 动态规划 完全背包问题

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 5}, 7));
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
