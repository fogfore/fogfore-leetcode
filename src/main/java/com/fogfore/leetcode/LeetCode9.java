package com.fogfore.leetcode;

/**
 * 回文数
 *
 * @author fogfore
 */
public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(2121));
    }
}
