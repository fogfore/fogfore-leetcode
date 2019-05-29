package com.fogfore.leetcode.l1;

import java.util.Arrays;

/**
 * 移除元素
 *
 * @author fogfore
 */
public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(array1, 2));
        System.out.println(Arrays.toString(array1));
    }
}
