package com.fogfore.leetcode.l2;

/**
 * 跳跃游戏
 *
 * @author fogfore
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int maxRight = 0;
        int start = 0;
        while (start <= maxRight && maxRight < nums.length - 1) {
            maxRight = Math.max(nums[start] + start, maxRight);
            start++;
        }
        return maxRight >= nums.length - 1;
    }

    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();
        System.out.println(leetCode55.canJump(new int[]{0, 2, 3}));
        System.out.println(leetCode55.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(leetCode55.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
