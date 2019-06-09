package com.fogfore.leetcode.l2;

import java.util.Arrays;

/**
 * 颜色分类
 *
 * @author fogfore
 */
public class LeetCode75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int pre = 0, next = nums.length - 1, cur = 0;
        while (cur <= next) {
            if (nums[cur] == 0) {
                swap(nums, pre, cur);
                pre++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, next, cur);
                next--;
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] array, int src, int dest) {
        if (src == dest) {
            return;
        }
        array[src] = array[src] ^ array[dest];
        array[dest] = array[src] ^ array[dest];
        array[src] = array[src] ^ array[dest];
    }

    public static void main(String[] args) {
        LeetCode75 leetCode75 = new LeetCode75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        leetCode75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
