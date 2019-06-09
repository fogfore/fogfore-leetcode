package com.fogfore.leetcode.l2;

/**
 * 编辑距离
 *
 * @author fogfore
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (word1.length() < 1) return word2.length();
        if (word2.length() < 1) return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] - 1);
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private static int min(int... values) {
        int min = Integer.MAX_VALUE;
        for (int v : values) {
            min = v < min ? v : min;
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
        System.out.println(leetCode72.minDistance("intention", "execution"));
        System.out.println(leetCode72.minDistance("horse", "ros"));
    }
}
