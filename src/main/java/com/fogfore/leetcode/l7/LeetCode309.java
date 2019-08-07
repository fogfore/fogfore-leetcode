package com.fogfore.leetcode.l7;

/**
 * 最佳买卖股票时机含冷冻期
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int dp_0 = 0, dp_1 = -prices[0], dp_pre_0 = 0;
        for (int i = 1; i < prices.length; i++) {
            int t = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, dp_pre_0 - prices[i]);
            dp_pre_0 = t;
        }
        return dp_0;
    }

    public static void main(String[] args) {
        LeetCode309 l = new LeetCode309();
        System.out.println(l.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(l.maxProfit(new int[]{6, 1, 6, 4, 3, 0, 2}));
    }
}
