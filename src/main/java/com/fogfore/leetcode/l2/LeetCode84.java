package com.fogfore.leetcode.l2;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 柱状图中最大的矩形
 *
 * @author fogfore
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }
    
//    public int largestRectangleArea(int[] heights) {
//        if (heights == null || heights.length < 1) return 0;
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int minHeight = Integer.MAX_VALUE;
//            for (int j = i; j >= 0; j--) {
//                minHeight = Math.min(minHeight, heights[j]);
//                maxArea = Math.max(maxArea, minHeight * (i - j + 1));
//            }
//        }
//        return maxArea;
//    }

    public static void main(String[] args) {
        LeetCode84 leetCode84 = new LeetCode84();
        System.out.println(leetCode84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
