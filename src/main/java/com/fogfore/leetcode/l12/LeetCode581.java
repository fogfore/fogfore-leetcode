package com.fogfore.leetcode.l12;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = nums[0], min = nums[nums.length - 1], r = -2, l = -1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - 1 - i]);
            if (max != nums[i]) r = i;
            if (min != nums[nums.length - 1 - i]) l = nums.length - i - 1;
        }
        return r - l + 1;
    }
}
