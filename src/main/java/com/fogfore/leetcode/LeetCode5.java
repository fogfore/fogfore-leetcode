package com.fogfore.leetcode;

/**
 * 最长回文子串
 * Manacher（马拉车）算法
 *
 * @author fogfore
 */
public class LeetCode5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        char[] chars = new char[s.length() * 2 + 2];
        int[] lr = new int[chars.length];
        int pos = 0;
        int maxRight = 1;
        int maxLen = 0;
        int maxPos = 0;

        chars[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            chars[maxRight++] = s.charAt(i);
            chars[maxRight++] = '#';
        }
        maxRight = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < maxRight) {
                lr[i] = lr[pos * 2 - i] < maxRight - i + 1 ? lr[pos * 2 - i] : maxRight - i + 1;
            } else {
                lr[i] = 1;
            }
            while (i - lr[i] >= 0 && i + lr[i] < chars.length && chars[i - lr[i]] == chars[i + lr[i]]) {
                lr[i]++;
            }
            pos = i;
            maxRight = i + lr[i] - 1;
            if (lr[i] - 1 > maxLen) {
                maxLen = lr[i] - 1;
                maxPos = i;
            }
        }
        int start = (maxPos - 1) / 2 - (maxLen - 1) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
