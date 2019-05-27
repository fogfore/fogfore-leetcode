package com.fogfore.leetcode;

import java.util.Arrays;

/**
 * 实现strStr()
 * KMP算法
 *
 * @author fogfore
 */
public class LeetCode28 {
    // KMP算法
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() < 1) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(needle, next);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void getNext(String str, int[] next) {
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }
    
//    public static int strStr(String haystack, String needle) {
//        if (haystack == null || needle == null || haystack.length() < needle.length()) {
//            return -1;
//        }
//        if (needle.length() < 1) {
//            return 0;
//        }
//        int point = 0;
//        int start = -1;
//        for (int i = 0; i < haystack.length(); i++) {
//            if (haystack.charAt(i) == needle.charAt(point)) {
//                start = point == 0 ? i : start;
//                point++;
//            } else {
//                point = 0;
//                i = start > -1 ? start : i;
//                start = -1;
//            }
//
//            if (point >= needle.length()) {
//                return start;
//            } else if (haystack.length() - i < needle.length() - point) {
//                return -1;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getNext("ababcab")));
//        System.out.println(Arrays.toString(getNext("aaabababca")));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }
}
