package com.fogfore.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 *
 * @author fogfore
 */
public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length < 1 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        int low, high, sum;
        List<Integer> temp;
        for (int i = 0; i < nums.length; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    res.add(temp);
                    while (low < high && nums[low] == nums[++low]) {}
                    while (low < high && nums[high] == nums[--high]) {}
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
