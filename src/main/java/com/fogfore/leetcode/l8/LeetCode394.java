package com.fogfore.leetcode.l8;

import java.util.LinkedList;

/**
 * 字符串解码
 */
public class LeetCode394 {
    public String decodeString(String s) {
        if (s == null || s.length() < 1) return "";
        LinkedList<StringBuilder> strs = new LinkedList<>();
        strs.addLast(new StringBuilder());
        LinkedList<Integer> nums = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                num.append(cur);
            }
            if ((cur >= 'a' && cur <= 'z') || cur >= 'A' && cur <= 'Z') {
                strs.peekLast().append(cur);
            }
            if (cur == '[') {
                nums.addLast(Integer.parseInt(num.toString()));
                num = new StringBuilder();
                strs.addLast(new StringBuilder());
            }
            if (cur == ']') {
                int count = nums.removeLast();
                StringBuilder sb = new StringBuilder("");
                String t = strs.removeLast().toString();
                while (count > 0) {
                    sb.append(t);
                    count--;
                }
                if (strs.isEmpty()) strs.addLast(sb);
                else strs.peekLast().append(sb);
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder t : strs) {
            res.append(t);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode394 l = new LeetCode394();
        System.out.println(l.decodeString("3[a2[c]]"));
        System.out.println(l.decodeString("2[abc]3[cd]ef"));
    }
}
