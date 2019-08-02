package com.fogfore.leetcode.l4;

import java.util.Arrays;

/**
 * 求众数
 */
public class LeetCode169 {
    // 投票算法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (candidate == n) ? 1 : -1;
        }
        return candidate;
    }

//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
}
