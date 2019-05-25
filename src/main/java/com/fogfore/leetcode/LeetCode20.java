package com.fogfore.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有效的括号
 *
 * @author fogfore
 */
public class LeetCode20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && ((stack.peekFirst() == '(' && s.charAt(i) == ')') ||
                    (stack.peekFirst() == '[' && s.charAt(i) == ']') ||
                    (stack.peekFirst() == '{' && s.charAt(i) == '}'))) {
                stack.removeFirst();
            } else {
                stack.addFirst(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("true " + isValid("()"));
        System.out.println("true " + isValid("()[]{}"));
        System.out.println("false " + isValid("(]"));
        System.out.println("false " + isValid("([)]"));
        System.out.println("true " + isValid("{[]}"));
    }
}
