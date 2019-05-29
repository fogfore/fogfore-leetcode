package com.fogfore.leetcode.l1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 最长有效括号
 *
 * @author fogfore
 */
public class LeetCode32 {
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    // 动态规划
//    public static int longestValidParentheses(String s) {
//        int[] cache = new int[s.length() + 1];
//        int max = 0;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    cache[i + 1] = cache[i - 1] + 2;
//                } else if (i - cache[i] - 1 >= 0 && s.charAt(i - cache[i] - 1) == '(') {
//                    cache[i + 1] = cache[i] + cache[i - cache[i] - 1] + 2;
//                }
//            }
//            max = Math.max(max, cache[i + 1]);
//        }
//        return max;
//    }

    // 栈
//    public static int longestValidParentheses(String s) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.addFirst(-1);
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (stack.peekFirst() == -1 || s.charAt(i) != ')' || s.charAt(stack.peekFirst()) != '(') {
//                stack.addFirst(i);
//            } else {
//                stack.removeFirst();
//                res = Math.max(i - stack.peekFirst(), res);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println("6 " + longestValidParentheses("(()())"));
        System.out.println("4 " + longestValidParentheses("(()()("));
        System.out.println("12 " + longestValidParentheses("(((()))((())(((())))("));
        System.out.println("2 " + longestValidParentheses("(()"));
    }
}
