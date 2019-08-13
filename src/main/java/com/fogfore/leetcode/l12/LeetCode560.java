package com.fogfore.leetcode.l12;

import java.util.HashMap;

/**
 * 和为K的子数组
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int curTotal = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : nums) {
            curTotal += n;
            count += map.getOrDefault(curTotal - k, 0);
            map.put(curTotal, map.getOrDefault(curTotal, 0) + 1);
        }
        return count;
    }
}
