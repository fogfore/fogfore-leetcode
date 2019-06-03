package com.fogfore.leetcode.l1;

/**
 * 通配符匹配
 *
 * @author fogfore
 */
public class LeetCode44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] matches = new boolean[2][p.length() + 1];
        matches[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (i > 0 && p.charAt(j - 1) != '*') {
                    matches[i & 1][j] = matches[(i + 1) & 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
                } else {
                    matches[i & 1][j] = p.charAt(j - 1) == '*' && (matches[i & 1][j - 1] || (i > 0 && matches[(i + 1) & 1][j]));
                }
            }
            matches[0][0] = i < 1;
        }
        return matches[s.length() & 1][p.length()];
    }

    public static void main(String[] args) {
        LeetCode44 leetCode44 = new LeetCode44();
        System.out.println("false " + leetCode44.isMatch("aab", "c*a*b"));
        System.out.println("false " + leetCode44.isMatch("adcbeafab", "**ad?b*ab**a"));
        System.out.println("true " + leetCode44.isMatch("adcbeafab", "**ad?b*ab**"));
    }
}
