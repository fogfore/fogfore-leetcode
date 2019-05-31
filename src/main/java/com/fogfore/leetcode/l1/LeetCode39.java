package com.fogfore.leetcode.l1;

import java.util.*;

/**
 * 组合总和
 *
 * @author fogfore
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        return null;
    }

    private void cal(int[] candidates, int target, int cur, int sum, LinkedList<Integer> queue, List<List<Integer>> res) {
        if (cur >= candidates.length) {
            return;
        }
        sum += candidates[cur];
        queue.add(candidates[cur]);
        while (sum < target) {
            cal(candidates, target, cur + 1, sum, queue, res);
            sum += candidates[cur];
            queue.add(candidates[cur]);
        }
        if (sum == target) {
            res.add(new LinkedList<>(queue));
        }
        while (!queue.isEmpty() && queue.peek() == candidates[cur]) {
            queue.remove();
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
