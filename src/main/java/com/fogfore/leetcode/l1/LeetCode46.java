package com.fogfore.leetcode.l1;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author fogfore
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        permute(nums, queue, res);
        return res;
    }

    private void permute(int[] nums, LinkedList<Integer> queue, List<List<Integer>> res) {
        if (queue.size() == nums.length) {
            res.add(new LinkedList<>(queue));
            return;
        }
        int cur;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                cur = nums[i];
                queue.addLast(cur);
                nums[i] = Integer.MAX_VALUE;
                permute(nums, queue, res);
                nums[i] = cur;
                queue.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        System.out.println(leetCode46.permute(new int[]{1, 2, 3}));
    }
}
