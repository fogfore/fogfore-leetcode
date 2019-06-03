package com.fogfore.leetcode.l1;

/**
 * 缺失的第一个正数
 *
 * @author fogfore
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        int res = 0;
        while (res < nums.length) {
            if (nums[res] != res + 1) {
                break;
            }
            res++;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        LeetCode41 leetCode41 = new LeetCode41();
        System.out.println(leetCode41.firstMissingPositive(new int[]{1}));
        System.out.println(leetCode41.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
