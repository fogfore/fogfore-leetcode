package com.fogfore.leetcode.l4;

/**
 * 打家劫舍
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    public static void main(String[] args) {
        LeetCode198 l = new LeetCode198();
        System.out.println(l.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
