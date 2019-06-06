package com.fogfore.leetcode.l3;

/**
 * 买卖股票的最佳时机
 *
 * @author fogfore
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode121 leetCode121 = new LeetCode121();
        System.out.println("5 " + leetCode121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("0 " + leetCode121.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
