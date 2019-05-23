package com.fogfore.leetcode;

/**
 * 正则表达式匹配
 * dp 和 dfs
 *
 * @author fogfore
 */
public class LeetCode10 {
    // dp 时空复杂度最优
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] matches = new boolean[2][p.length() + 1];
        matches[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                matches[0][i + 1] = matches[0][i - 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (j > 0 && p.charAt(j) == '*') {
                    matches[(i + 1) & 1][j + 1] = matches[(i + 1) & 1][j - 1] ||
                            ((p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') && matches[i & 1][j + 1]);
                } else {
                    matches[(i + 1) & 1][j + 1] = (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && matches[i & 1][j];
                }
            }
            matches[0][0] = false;
        }
        return matches[s.length() & 1][p.length()];
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
        System.out.println("true " + isMatch("ab", ".*"));
        System.out.println("true " + isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"));
        System.out.println("true " + isMatch("aab", "c*a*b"));
        System.out.println("false " + isMatch("abcd", "d*"));
        System.out.println("false " + isMatch("mississippi", "mis*is*p*."));
        System.out.println("true " + isMatch("aa", "a*"));
        System.out.println("false " + isMatch("aa", "a"));
        System.out.println("true " + isMatch("a", "ab*"));
        System.out.println("true " + isMatch("", ".*"));
        System.out.println("true " + isMatch("", "a*"));
    }
}
