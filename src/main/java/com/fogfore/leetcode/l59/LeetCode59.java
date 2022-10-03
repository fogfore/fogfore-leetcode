package com.fogfore.leetcode.l59;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 */
public class LeetCode59 {
    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        System.out.println(Arrays.deepToString(leetCode59.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        helper(n, 1, matrix, 0);
        return matrix;
    }

    public void helper(int n, int start, int[][] matrix, int x) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            matrix[x][x] = start;
            return;
        }

        for (int i = x; i < x + n - 1; i++) {
            matrix[x][i] = start;
            start++;
        }
        for (int j = x; j < x + n - 1; j++) {
            matrix[j][x + n - 1] = start;
            start++;
        }
        for (int k = x + n - 1; k > x; k--) {
            matrix[x + n - 1][k] = start;
            start++;
        }
        for (int l = x + n - 1; l > x; l--) {
            matrix[l][x] = start;
            start++;
        }
        helper(n - 2, start, matrix, x + 1);
    }
}
