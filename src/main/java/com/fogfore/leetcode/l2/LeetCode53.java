package com.fogfore.leetcode.l2;

/**
 * 最大子序和
 *
 * @author fogfore
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = sum > maxSum ? sum : maxSum;
            sum = sum < 0 ? 0 : sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        System.out.println(leetCode53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
