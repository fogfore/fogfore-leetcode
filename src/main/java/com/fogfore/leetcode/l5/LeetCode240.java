package com.fogfore.leetcode.l5;

/**
 * 搜索二维矩阵 II
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        // 水平二分法
        for (int i = 0; i < matrix.length; i++) {
            int low = 0, high = matrix[0].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
