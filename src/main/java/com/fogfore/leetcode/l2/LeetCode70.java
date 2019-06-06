package com.fogfore.leetcode.l2;

/**
 * 爬楼梯
 *
 * @author fogfore
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        System.out.println(leetCode70.climbStairs(3));
    }
}
