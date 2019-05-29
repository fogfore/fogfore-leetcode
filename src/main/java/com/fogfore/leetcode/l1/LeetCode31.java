package com.fogfore.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 下一个排列
 *
 * @author fogfroe
 */
public class LeetCode31 {
    public static void nextPermutation(int[] nums) {
        int i1 = 0, i2 = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                i1 = i;
                break;
            }
        }
        for (int i = i1 + 1; i < nums.length; i++) {
            if (nums[i] <= nums[i1]) {
                i2 = i - 1;
                break;
            } else if (i == nums.length - 1) {
                i2 = i;
            }
        }
        swap(nums, i1, i2);
        int low = i2 == 0 ? 0 : i1 + 1;
        int high = nums.length - 1;
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private static void swap(int[] nums, int src, int dest) {
        if (src == dest) {
            return;
        }
        nums[src] = nums[src] ^ nums[dest];
        nums[dest] = nums[src] ^ nums[dest];
        nums[src] = nums[src] ^ nums[dest];
    }

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 1};
        int[] array2 = {1, 2, 3, 4};
        int[] array3 = {4, 3, 2, 1};
        int[] array4 = {1, 1, 3, 4};
        int[] array5 = {1, 3, 5, 4};
        nextPermutation(array1);
        nextPermutation(array2);
        nextPermutation(array3);
        nextPermutation(array4);
        nextPermutation(array5);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
    }
}
