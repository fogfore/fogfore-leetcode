package com.fogfore.leetcode;

/**
 * 无重复最长字串
 *
 * @author fogfore
 */
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int[] preIndexes = new int[256];
        for (int i = 0; i < preIndexes.length; i++) {
            preIndexes[i] = -1;
        }
        int curLen = 0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = preIndexes[str.charAt(i)];
            if (index == -1 || i - index > curLen) {
                curLen++;
            } else {
                curLen = i - index;
            }
            preIndexes[str.charAt(i)] = i;
            maxLen = curLen > maxLen ? curLen : maxLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
