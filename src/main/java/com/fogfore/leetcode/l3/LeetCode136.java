package com.fogfore.leetcode.l3;

/**
 * 只出现一次的数字
 *
 * @author fogfore
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode136 leetCode136 = new LeetCode136();
        System.out.println(leetCode136.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
