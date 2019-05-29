package com.fogfore.leetcode;

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
    // 动态规划
    public static int longestValidParentheses(String s) {

        return 0;
    }

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

//    public static int longestValidParentheses(String s) {
//        Deque<Character> charStack = new ArrayDeque<>();
//        Deque<Integer> numStack = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (charStack.isEmpty() || charStack.peekFirst() != '(' || s.charAt(i) != ')') {
//                charStack.addFirst(s.charAt(i));
//                numStack.addFirst(0);
//            } else {
//                charStack.removeFirst();
//                numStack.addFirst(numStack.getFirst() + 1);
//            }
//        }
//        int count = 0;
//        int tmpCount = 0;
//        int num;
//        int zeroNum;
//        int nonZeroNum;
//        Iterator<Integer> iterator;
//        while (!numStack.isEmpty()) {
//            if (numStack.peekFirst() == 0) {
//                numStack.removeFirst();
//                count = tmpCount > count ? tmpCount : count;
//                tmpCount = 0;
//                continue;
//            }
//            num = numStack.peekFirst();
//            tmpCount += num;
//            zeroNum = num;
//            nonZeroNum = num;
//            iterator = numStack.iterator();
//            while (iterator.hasNext()) {
//                num = iterator.next();
//                if (zeroNum > 0 && num == 0) {
//                    iterator.remove();
//                    zeroNum--;
//                } else if (nonZeroNum > 0 && num > 0) {
//                    iterator.remove();
//                    nonZeroNum--;
//                } else if (zeroNum <= 0 && nonZeroNum <= 0) {
//                    break;
//                }
//            }
//        }
//        count = tmpCount > count ? tmpCount : count;
//        return count << 1;
//    }

    public static void main(String[] args) {
        System.out.println("6 " + longestValidParentheses("(()())"));
        System.out.println("4 " + longestValidParentheses("(()()("));
        System.out.println("12 " + longestValidParentheses("(((()))((())(((())))("));
        System.out.println("2 " + longestValidParentheses("(()"));
    }
}
