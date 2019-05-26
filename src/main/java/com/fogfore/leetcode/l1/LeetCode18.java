package com.fogfore.leetcode.l1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 四数之和
 *
 * @author fogfore
 */
public class LeetCode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
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
            for (int j = i + 1; j < nums.length; j++) {
                low = j + 1;
                high = nums.length - 1;
                while (low < high) {
                    sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        temp = new LinkedList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);
                        while (low < high && nums[low] == nums[++low]) {
                        }
                        while (low < high && nums[high] == nums[--high]) {
                        }
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
