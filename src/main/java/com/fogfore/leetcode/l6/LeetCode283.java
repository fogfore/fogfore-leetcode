package com.fogfore.leetcode.l6;

/**
 * 移动零
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int j = nums.length - count; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
