package com.fogfore.leetcode.l1;

import java.util.*;

/**
 * 组合总和 II
 *
 * @author fogfore
 */
public class LeetCode40 {
    // 回溯法
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.sort(candidates);
        cal(candidates, target, 0, 0, queue, res);
        return res;
    }

    private void cal(int[] candidates, int target, int cur, int sum, LinkedList<Integer> queue, List<List<Integer>> res) {
        if (cur >= candidates.length || sum > target) {
            return;
        }
        sum += candidates[cur];
        queue.addFirst(candidates[cur]);
        if (sum < target) {
            cal(candidates, target, cur + 1, sum, queue, res);
        }
        if (sum == target) {
            res.add(new LinkedList<>(queue));
        }
        sum -= candidates[cur];
        queue.removeFirst();
        while (cur < candidates.length - 1 && candidates[cur] == candidates[cur + 1]) {
            cur++;
        }
        cal(candidates, target, cur + 1, sum, queue, res);
    }

    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        System.out.println(leetCode40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(leetCode40.combinationSum2(new int[]{2, 3, 5}, 7));
        System.out.println(leetCode40.combinationSum2(new int[]{2, 3, 6, 7}, 7));
        System.out.println(leetCode40.combinationSum2(new int[]{2, 3, 5}, 8));
    }
}
