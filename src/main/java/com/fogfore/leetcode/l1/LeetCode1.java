package com.fogfore.leetcode.l1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * @author fogfore
 */
public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(50);
        int complement = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
