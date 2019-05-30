package com.fogfore.leetcode.l1;

/**
 * 搜索插入位置
 *
 * @author fogfore
 */
public class LeetCode35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 1));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 0));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 3));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 4));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 11));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 8, 9, 10}, 10));
    }
}
