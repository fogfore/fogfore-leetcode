package com.fogfore.leetcode.l58;

/**
 * 最后一个单词的长度
 */
public class LeetCode58 {
    //    public int lengthOfLastWord(String s) {
//        String[] split = s.trim().split("\\s+");
//        return split[split.length - 1].length();
//    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
