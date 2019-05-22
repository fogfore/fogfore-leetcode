package com.fogfore.leetcode;

/**
 * 正则表达式匹配
 * dp 和 dfs
 *
 * @author fogfore
 */
public class LeetCode10 {
    // dp
    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen + 1][pLen + 1];
        memory[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    memory[i][j] = memory[i][j - 2] ||
                            (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && memory[i - 1][j]);
                } else {
                    memory[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && memory[i - 1][j - 1];
                }
            }
        }
        return memory[sLen][pLen];
    }

    // dfs
//    public static boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//        return isMatch(s, 0, p, 0);
//    }
//
//    public static boolean isMatch(String s, int si, String p, int pi) {
//        if (si >= s.length() && pi >= p.length()) {
//            return true;
//        } else if (si < s.length() && pi >= p.length()) {
//            return false;
//        }
//        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
//            if (si < s.length() && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi))) {
//                return isMatch(s, si + 1, p, pi) || isMatch(s, si + 1, p, pi + 2) || isMatch(s, si, p, pi + 2);
//            }
//            return isMatch(s, si, p, pi + 2);
//        }
//        if (si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
//            return isMatch(s, si + 1, p, pi + 1);
//        }
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("a", "ab*"));
    }
}
