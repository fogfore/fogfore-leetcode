package com.fogfore.leetcode.l1;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 *
 * @author fogfore
 */
public class LeetCode26 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int p1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p1]) {
                nums[++p1] = nums[i];
            }
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array1));
        System.out.println(Arrays.toString(array1));
    }
}
