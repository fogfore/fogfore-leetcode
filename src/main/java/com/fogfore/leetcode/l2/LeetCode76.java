package com.fogfore.leetcode.l2;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author fogfore
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() < 1 || s.length() < 1) return "";
        Map<Character, Integer> dictMap = new HashMap<>();
        for (Character c : t.toCharArray()) dictMap.put(c, dictMap.getOrDefault(c, 0) + 1);
        int right = 0, left = 0;
        Map<Character, Integer> window = new HashMap<>();
        int[] res = {-1, 0, 0};
        int formed = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (dictMap.containsKey(ch) && window.get(ch).intValue() == dictMap.get(ch).intValue()) formed++;
            while (left <= right && formed == dictMap.size()) {
                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }
                ch = s.charAt(left);
                window.put(ch, window.get(ch) - 1);
                if (dictMap.containsKey(ch) && window.get(ch) < dictMap.get(ch)) formed--;
                left++;
            }
            right++;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
