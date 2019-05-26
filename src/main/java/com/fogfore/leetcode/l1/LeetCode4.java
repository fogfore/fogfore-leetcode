package com.fogfore.leetcode.l1;

/**
 * 寻找两个有序数组的中位数
 *
 * @author fogfore
 */
public class LeetCode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean oddFlag = ((nums1.length + nums2.length) & 1) == 1;
        int mid = (nums1.length + nums2.length) / 2;
        int curIndex = 0;
        int curNum = 0, preNum = 0;
        boolean preNumPresent = false;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                curNum = nums1[i];
                i++;
            } else {
                curNum = nums2[j];
                j++;
            }
            curIndex++;
            if (curIndex == mid) {
                preNum = curNum;
            } else if (curIndex > mid) {
                break;
            }
        }
        while (i < nums1.length) {
            if (curIndex == mid) {
                preNum = curNum;
            } else if (curIndex > mid) {
                break;
            }
            curNum = nums1[i];
            curIndex++;
            i++;
        }

        while (j < nums2.length) {
            if (curIndex == mid) {
                preNum = curNum;
            } else if (curIndex > mid) {
                break;
            }
            curNum = nums2[j];
            curIndex++;
            j++;
        }
        if (oddFlag) {
            return curNum;
        } else {
            return (curNum + preNum) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
