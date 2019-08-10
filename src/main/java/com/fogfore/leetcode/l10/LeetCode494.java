package com.fogfore.leetcode.l10;

/**
 * 目标和
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (((sum + S) & 1) == 1 || sum < S) return 0;
        int capacity = (sum + S) / 2;
        int[][] dp = new int[nums.length + 1][capacity + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j] + (j - nums[i - 1] >= 0 ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
        return dp[nums.length][capacity];
    }

    public static void main(String[] args) {
        LeetCode494 l = new LeetCode494();
        System.out.println(l.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
