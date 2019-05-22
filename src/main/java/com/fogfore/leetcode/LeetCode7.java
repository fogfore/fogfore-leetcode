package com.fogfore.leetcode;

/**
 * 整数反转
 *
 * @author fogfore
 */
public class LeetCode7 {
    public static int reverse(int x) {
        int rest = 0;
        int result = 0;
        while (x != 0) {
            rest = x % 10;
            if ((rest > 0 && result > (Integer.MAX_VALUE - rest) / 10) || (rest < 0 && result < (Integer.MIN_VALUE - rest) / 10)) {
                return 0;
            }
            result = result * 10 + rest;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
