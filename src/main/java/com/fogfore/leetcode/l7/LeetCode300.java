package com.fogfore.leetcode.l7;

/**
 * 最长上升子序列
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 超时
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length < 1) return 0;
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, helper(nums, i, i + 1) + 1);
//        }
//        return max;
//    }
//
//    private int helper(int[] nums, int pre, int start) {
//        if (start >= nums.length) return 0;
//        for (int i = start; i < nums.length; i++) {
//            if (nums[i] > nums[pre]) {
//                return Math.max(helper(nums, i, i + 1) + 1, helper(nums, pre, i + 1));
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        LeetCode300 l = new LeetCode300();
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 2, 3, 7, 101, 18}));
    }
}
