package com.fogfore.leetcode.l7;

/**
 * 零钱兑换
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int delta = i - coins[j];
                if (delta >= 0 && dp[delta] >= 0) {
                    dp[i] = dp[i] == -1 ? dp[delta] + 1 : Math.min(dp[i], dp[delta] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        LeetCode322 l = new LeetCode322();
        System.out.println(l.coinChange(new int[]{1, 2, 5}, 12));
    }
}
