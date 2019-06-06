package com.fogfore.leetcode.l2;

/**
 * 不同路径
 *
 * @author fogfore
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return 0;
        int[][] dp = new int[2][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i & 1][j] = 1;
                } else {
                    dp[i & 1][j] = dp[(i + 1) & 1][j] + dp[i & 1][j - 1];
                }
            }
        }
        return dp[(n + 1) & 1][m - 1];
    }

    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        System.out.println("28 " + leetCode62.uniquePaths(7, 3));
    }
}
