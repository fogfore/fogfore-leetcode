package com.fogfore.leetcode.l1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Pow(x, n)
 *
 * @author fogfore
 */
public class LeetCode50 {
    // n 的范围[0x80000000,0x7fffffff]
    public double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = myPow(x, n / 2);
        return (n & 1) == 1 ? res * res * x : res * res;
    }

    public static void main(String[] args) {
        LeetCode50 leetCode50 = new LeetCode50();
        System.out.println(leetCode50.myPow(2.00000, -2147483648));
        System.out.println(leetCode50.myPow(2.10000, 3));
        System.out.println(leetCode50.myPow(2, -2));
    }
}
