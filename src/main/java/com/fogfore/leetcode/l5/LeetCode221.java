package com.fogfore.leetcode.l5;

import java.util.LinkedList;

/**
 * 最大正方形
 */
public class LeetCode221 {
    // dp
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

//    public int maximalSquare(char[][] matrix) {
//        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
//        int[] highs = new int[matrix[0].length];
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.addLast(-1);
//        int max = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < highs.length; j++) {
//                highs[j] = matrix[i][j] == '0' ? 0 : highs[j] + 1;
//                while (queue.peekLast() != -1 && highs[queue.peekLast()] >= highs[j]) {
//                    int ops = queue.removeLast();
//                    int len = Math.min(highs[ops], j - queue.peekLast() - 1);
//                    max = Math.max(max, len * len);
//                }
//                if (queue.peekLast() == -1 || highs[queue.peekLast()] < highs[j]) {
//                    queue.addLast(j);
//                }
//            }
//            while (queue.peekLast() != -1) {
//                int ops = queue.removeLast();
//                int len = Math.min(highs[ops], highs.length - queue.peekLast() - 1);
//                max = Math.max(max, len * len);
//            }
//        }
//        return max;
//    }
}
