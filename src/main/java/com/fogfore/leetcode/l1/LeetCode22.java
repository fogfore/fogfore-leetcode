package com.fogfore.leetcode.l1;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 *
 * @author fogfore
 */
public class LeetCode22 {
    // 闭合数
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        for (int i = 0; i < n; i++) {
            for (String left : generateParenthesis(i)) {
                for (String right : generateParenthesis(n - 1 - i)) {
                    res.add(left + "(" + right + ")");
                }
            }
        }
        return res;
    }

//    // 回溯法
//    public static List<String> generateParenthesis(int n) {
//        if (n < 0) {
//            return null;
//        }
//        LinkedList<String> res = new LinkedList<>();
//        generateParenthesis(res, "", 0, 0, n);
//        return res;
//    }
//
//    private static void generateParenthesis(List<String> res, String cur, int open, int close, int max) {
//        if (cur.length() >= max << 1) {
//            res.add(cur);
//            return;
//        }
//        if (open < max) {
//            generateParenthesis(res, cur + "(", open + 1, close, max);
//        }
//        if (close < open) {
//            generateParenthesis(res, cur + ")", open, close + 1, max);
//        }
//    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
