package com.fogfore.leetcode.l1;

/**
 * 跳跃游戏 II
 */
public class LeetCode45 {
    // 贪心算法
    public int jump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.min(nums[i] + i, nums.length - 1); j > 0 && dp[j] == 0; j--) {
                dp[j] = dp[i] + 1;
                if (j >= nums.length - 1) {
                    return dp[j];
                }
            }
        }
        return 0;
    }

    // 动态规划 超时
//    public int jump(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//        int[] cache = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
//                cache[i + j] = cache[i + j] == 0 ? cache[i] + 1 : Math.min(cache[i] + 1, cache[i + j]);
//            }
//        }
//        return cache[nums.length - 1];
//    }

    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();
        System.out.println(leetCode45.jump(new int[]{1, 2}));
        System.out.println(leetCode45.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
