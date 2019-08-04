package com.fogfore.leetcode.l5;

/**
 * 数组中的第K个最大元素
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = partition(nums, low, high);
            if (mid == k) {
                return nums[mid];
            } else if (mid < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private int partition(int[] nums, int low, int high) {
        int cur = low, small = low;
        while (cur < high) {
            if (nums[cur] < nums[high]) {
                swap(nums, cur, small);
                small++;
            }
            cur++;
        }
        swap(nums, small, high);
        return small;
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
