package com.fogfore.leetcode.l1;

/**
 * 搜索旋转排序数组
 *
 * @author fogfore
 */
public class LeetCode33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                if (mid != high && nums[mid] >= nums[high] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (mid != low && nums[mid] <= nums[low] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3}, 3));
        System.out.println(search(new int[]{3, 1}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
