package com.fogfore.leetcode.l9;

/**
 * 分割等和子集
 */
public class LeetCode416 {
    // dp
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 1) return true;
        if (nums.length < 2) return false;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        int capacity = sum / 2 + 1;
        boolean[][] dp = new boolean[nums.length][capacity];
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < capacity; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= nums[i] && dp[i - 1][j - nums[i]]);
            }
        }
        return dp[nums.length - 1][sum / 2];
    }

    // 超时
//    public boolean canPartition(int[] nums) {
//        if (nums == null || nums.length < 1) return true;
//        if (nums.length < 2) return false;
//        int set2 = 0, set1 = 0;
//        for (int n : nums) {
//            set2 += n;
//        }
//        return helper(nums, set1, set2, 0);
//    }
//
//    private boolean helper(int[] nums, int set1, int set2, int i) {
//        if (set1 == set2) return true;
//        if (i >= nums.length) return false;
//        return (set1 <= set2 && helper(nums, set1, set2, i + 1)) ||
//                (set1 + nums[i] <= set2 - nums[i] && helper(nums, set1 + nums[i], set2 - nums[i], i + 1));
//    }

    public static void main(String[] args) {
        LeetCode416 l = new LeetCode416();
        System.out.println(l.canPartition(new int[]{1, 5, 11, 5}));
    }
}
