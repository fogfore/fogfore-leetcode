package com.fogfore.leetcode.l9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> res = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                while (count > 0) {
                    char t = s.charAt(i - count);
                    map.put(t, map.get(t) + 1);
                    count--;
                }
                continue;
            }
            map.put(c, map.get(c) - 1);
            count++;
            while (count > 0 && map.get(s.charAt(i)) < 0) {
                char t = s.charAt(i - count + 1);
                map.put(t, map.get(t) + 1);
                count--;
            }
            if (count == p.length()) res.add(i - count + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode438 l = new LeetCode438();
        System.out.println(l.findAnagrams("abaacbabc","abc"));
        System.out.println(l.findAnagrams("cbaebabacd", "abc"));
        System.out.println(l.findAnagrams("abab", "ab"));
        System.out.println(l.findAnagrams("", "ab"));
        System.out.println(l.findAnagrams("", ""));
    }
}
