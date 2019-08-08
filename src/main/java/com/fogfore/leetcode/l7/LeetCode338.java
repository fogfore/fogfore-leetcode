package com.fogfore.leetcode.l7;

import java.util.Arrays;

/**
 * 比特位计数
 */
public class LeetCode338 {
    // 最低有效位
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        LeetCode338 l = new LeetCode338();
        System.out.println(Arrays.toString(l.countBits(5)));
    }
}
