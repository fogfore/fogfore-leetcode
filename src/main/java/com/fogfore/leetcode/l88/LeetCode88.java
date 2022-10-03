package com.fogfore.leetcode.l88;

/**
 * 合并两个有序数组
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (index >= 0) {
            if (n >= 0 && m >= 0 && nums1[m] <= nums2[n]) {
                nums1[index] = nums2[n];
                n--;
            } else if (n >= 0 && m >= 0 && nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else if (m < 0) {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
    }
}
