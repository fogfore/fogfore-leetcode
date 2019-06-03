package com.fogfore.leetcode.l1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 *
 * @author fogfore
 */
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        Arrays.sort(nums);
        LinkedList<Integer> queue = new LinkedList<>();
        permuteUnique(nums, queue, res);
        return res;
    }

    private void permuteUnique(int[] nums, LinkedList<Integer> queue, List<List<Integer>> res) {
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
                permuteUnique(nums, queue, res);
                nums[i] = cur;
                queue.removeLast();
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode47 LeetCode47 = new LeetCode47();
        System.out.println(LeetCode47.permuteUnique(new int[]{3, 3, 0, 3}));
        System.out.println(LeetCode47.permuteUnique(new int[]{1, 1, 2}));
    }
}
