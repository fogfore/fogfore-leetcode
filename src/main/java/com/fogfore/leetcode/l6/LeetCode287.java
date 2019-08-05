package com.fogfore.leetcode.l6;

import java.util.Arrays;

/**
 * 寻找重复数
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return 0;
    }
}
