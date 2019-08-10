package com.fogfore.leetcode.l10;

/**
 * 汉明距离
 */
public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int res = 0;
        while (t != 0) {
            res++;
            t &= (t - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode461 l = new LeetCode461();
        System.out.println(l.hammingDistance(1, 4));
    }
}
