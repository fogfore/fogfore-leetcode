package com.fogfore.leetcode.l7;

/**
 * 戳气球
 */
public class LeetCode312 {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] ns = new int[nums.length + 2];
        System.arraycopy(nums, 0, ns, 1, nums.length);
        ns[0] = 1;
        ns[ns.length - 1] = 1;
        // 按步长打表
        for (int len = 2; len < ns.length; len++) {
            for (int i = 0; i < ns.length - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], ns[i] * ns[k] * ns[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][ns.length - 1];
    }

    public static void main(String[] args) {
        LeetCode312 l = new LeetCode312();
        System.out.println(l.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
