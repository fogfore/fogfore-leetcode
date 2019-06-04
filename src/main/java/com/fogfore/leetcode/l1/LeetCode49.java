package com.fogfore.leetcode.l1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author fogfore
 */
public class LeetCode49 {
    // 方法1
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // 方法2
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) return new ArrayList();
//        Map<String, List> ans = new HashMap<String, List>();
//        int[] count = new int[26];
//        for (String s : strs) {
//            Arrays.fill(count, 0);
//            for (char c : s.toCharArray()) count[c - 'a']++;
//
//            StringBuilder sb = new StringBuilder("");
//            for (int i = 0; i < 26; i++) {
//                sb.append('#');
//                sb.append(count[i]);
//            }
//            String key = sb.toString();
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());
//    }

    public static void main(String[] args) {
        LeetCode49 leetCode49 = new LeetCode49();
        System.out.println(leetCode49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
