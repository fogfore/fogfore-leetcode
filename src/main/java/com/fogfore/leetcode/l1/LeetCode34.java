package com.fogfore.leetcode.l1;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author fogfore
 */
public class LeetCode34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length < 1) {
            return res;
        }
        int mid = 0, low = 0, high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                if (mid - 1 >= low && nums[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    res[0] = mid;
                    break;
                }
            }
        }
        if (res[0] == -1) {
            return res;
        }
        low = mid;
        high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                if (mid + 1 <= high && nums[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    res[1] = mid;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 2, 3, 4}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 4, 5, 5}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 4, 5, 6}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 4, 6, 6}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 4, 5, 5, 5}, 5)));
    }
}
