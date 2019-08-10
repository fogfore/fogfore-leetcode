package com.fogfore.leetcode.l9;

import java.util.LinkedList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 */
public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.addLast(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int src, int dest) {
        if (src == dest) return;
        nums[src] = nums[src] ^ nums[dest];
        nums[dest] = nums[src] ^ nums[dest];
        nums[src] = nums[src] ^ nums[dest];
    }

    public static void main(String[] args) {
        LeetCode448 l = new LeetCode448();
        System.out.println(l.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
