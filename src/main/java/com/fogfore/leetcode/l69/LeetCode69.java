package com.fogfore.leetcode.l69;

/**
 * x的平凡根
 */
public class LeetCode69 {
    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        int res = leetCode69.mySqrt(0);
        System.out.println(res);
    }

//    public int mySqrt(int x) {
//        double i = 0;
//        while (i * i <= x) {
//            i++;
//        }
//        return (int) (i - 1);
//    }

//    public int mySqrt(int x) {
//        if (0 == x) {
//            return 0;
//        }
//        int res = (int) Math.exp(0.5 * Math.log(x));
//        return (res + 1) * (res + 1) <= x ? res + 1 : res;
//    }

//    public int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//
//        double C = x, x0 = x;
//        while (true) {
//            double xi = 0.5 * (x0 + C / x0);
//            if (Math.abs(x0 - xi) < 1e-7) {
//                break;
//            }
//            x0 = xi;
//        }
//        return (int) x0;
//    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long l = 0, r = x;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid > x) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return (int) ans;
    }
}
