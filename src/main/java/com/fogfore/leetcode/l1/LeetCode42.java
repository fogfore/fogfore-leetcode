package com.fogfore.leetcode.l1;

/**
 * 接雨水
 *
 * @author fogfore
 */
public class LeetCode42 {
    // 双指针1
    public int trap(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int res = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    res += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    res += (right_max - height[right]);
                }
                --right;
            }
        }
        return res;
    }
    //  双指针2
//    public int trap(int[] height) {
//        int curHeight = 0, res = 0, low = 0, high = height.length - 1;
//        while (low < high) {
//            if (height[low] > curHeight && height[high] > curHeight) {
//                res += (Math.min(height[low], height[high]) - curHeight) * (high - low - 1);
//                curHeight = Math.min(height[low], height[high]);
//            }
//            if (high - low > 1) {
//                if (height[low] <= height[high]) {
//                    low++;
//                    res -= Math.min(height[low], curHeight);
//                } else {
//                    high--;
//                    res -= Math.min(height[high], curHeight);
//                }
//            } else {
//                break;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        LeetCode42 leetCode42 = new LeetCode42();
        System.out.println("6 " + leetCode42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("0 " + leetCode42.trap(new int[]{0}));
    }
}
