package com.fogfore.leetcode;

/**
 * 盛最多水的容器
 * 双指针
 *
 * @author fogfore
 */
public class LeetCode11 {
    public static int maxArea(int[] height) {
        int maxVolume = 0;
        int low = 0, high = height.length - 1;
        while (low < high) {
            maxVolume = Math.max(maxVolume, Math.min(height[low], height[high]) * (high - low));
            if (height[low] > height[high]) {
                high--;
            } else {
                low++;
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
