package com.fogfore.leetcode.l4;

import java.util.LinkedList;

/**
 * 最小栈
 */
public class LeetCode155 {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> min = new LinkedList<>();

    public LeetCode155() {

    }

    public void push(int x) {
        stack.push(x);
        min.push(Math.min(min.peek() == null ? x : min.peek(), x));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek() == null ? 0 : stack.peek();
    }

    public int getMin() {
        return min.peek() == null ? 0 : min.peek();
    }

    public static void main(String[] args) {
        LeetCode155 minStack = new LeetCode155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
