package com.fogfore.leetcode.l3;

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 *
 * @author fogfore
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                for (String word : wordDict) {
                    if (s.startsWith(word, i)) {
                        dp[i + word.length()] = 1;
                        if (dp[s.length()] == 1) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] wordDict = {"apple", "pen"};
        String[] wordDict2 = {"cats", "dog", "sand", "and", "cat"};
        LeetCode139 leetCode139 = new LeetCode139();
        System.out.println("trur " + leetCode139.wordBreak("applepenapple", Arrays.asList(wordDict)));
        System.out.println("false " + leetCode139.wordBreak("catsandog", Arrays.asList(wordDict2)));
    }
}
