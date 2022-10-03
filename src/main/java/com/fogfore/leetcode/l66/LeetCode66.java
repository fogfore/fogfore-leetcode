package com.fogfore.leetcode.l66;

/**
 * 加一
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int num = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + num;
            if (sum == 10) {
                digits[i] = 0;
            } else {
                digits[i] = sum;
                return digits;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

    }
}
