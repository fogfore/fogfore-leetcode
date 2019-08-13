package com.fogfore.leetcode.l13;

import com.fogfore.leetcode.l1.LeetCode4;

/**
 * 回文子串
 */
public class LeetCode647 {
    // 暴力法
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            for (int j = 0; j < i; j++) {
                int low = j, high = i;
                while (low < high) {
                    if (s.charAt(low) != s.charAt(high)) {
                        break;
                    } else {
                        low++;
                        high--;
                    }
                }
                if (low >= high) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode647 l = new LeetCode647();
        System.out.println(l.countSubstrings("aaa"));
    }
}
