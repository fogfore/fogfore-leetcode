package com.fogfore.leetcode.l3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 最长连续序列
 *
 * @author fogfore
 */
public class LeetCode128 {

    //  O(n)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int maxLen = 1;
        for (int n : set) {
            int curNum = n;
            int curLen = 1;
            while (set.contains(curNum + 1)) {
                curNum++;
                curLen++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    // O(nlgn)
//    public int longestConsecutive(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int maxLen = 1, len = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                continue;
//            } else if (nums[i] == nums[i - 1] + 1) {
//                len++;
//                maxLen = Math.max(maxLen, len);
//            } else {
//                len = 1;
//            }
//        }
//        return maxLen;
//    }

    public static void main(String[] args) {
        LeetCode128 leetCode128 = new LeetCode128();
        System.out.println(leetCode128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
