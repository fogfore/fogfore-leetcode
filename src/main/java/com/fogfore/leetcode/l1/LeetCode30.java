package com.fogfore.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 *
 * @author fogfore
 */
public class LeetCode30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (words == null || words.length < 1 || s == null || s.length() < 1 || s.length() < words[0].length() * words.length) {
            return res;
        }
        int wordLen = words[0].length();
        int wordNum = words.length;
        int allWordsLen = wordLen * wordNum;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tmpWordMap = new HashMap<>();
        String tmpWord;
        int left, right, count;
        for (int i = 0; i < wordLen; i++) {
            left = i;
            right = i;
            count = 0;
            tmpWordMap.clear();
            while (right + wordLen <= s.length()) {
                tmpWord = s.substring(right, right + wordLen);
                tmpWordMap.put(tmpWord, tmpWordMap.getOrDefault(tmpWord, 0) + 1);
                right += wordLen;
                count++;
                while (tmpWordMap.get(tmpWord) > wordMap.getOrDefault(tmpWord, 0)) {
                    String t_tmpWord = s.substring(left, left + wordLen);
                    tmpWordMap.put(t_tmpWord, tmpWordMap.get(t_tmpWord) - 1);
                    left += wordLen;
                    count--;
                }
                if (count == wordNum) {
                    res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
    }
}
