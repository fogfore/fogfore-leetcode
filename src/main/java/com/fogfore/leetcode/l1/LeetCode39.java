package com.fogfore.leetcode.l1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author fogfore
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int pre = 0, next = 0;
        int sum = 0;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        while (next < candidates.length && pre <= next && candidates[pre] <= target) {
            sum += candidates[next];
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int i = pre; i <= next; i++) {
                    temp.add(candidates[i]);
                }
                res.add(temp);
                next++;
            } else if (sum > target) {
                sum -= candidates[pre];
                pre++;
            } else {
                next++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
