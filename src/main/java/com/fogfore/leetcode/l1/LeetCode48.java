package com.fogfore.leetcode.l1;

import com.fogfore.algorithm.utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 旋转图像
 *
 * @author fogfore
 */
public class LeetCode48 {
    // 方法1
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    // 方法2
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        // transpose matrix
//        for(int i = 0; i < n - 1; i++) {
//            for(int j = 0; j < n - i - 1; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n-j-1][n-i-1];
//                matrix[n-j-1][n-i-1] = temp;
//            }
//        }
//        // reverse each row
//        for(int i = 0; i < n / 2; i++) {
//            for(int j = 0; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n-i-1][j];
//                matrix[n-i-1][j] = temp;
//            }
//        }
//    }

    // 方法3
//    public void rotate(int[][] matrix) {
//        if (matrix == null) {
//            return;
//        }
//        int start = 0;
//        while (start <= (matrix.length - 1) / 2) {
//            rotate(matrix, start);
//            start++;
//        }
//    }
//
//    private void rotate(int[][] matrix, int start) {
//        int len = matrix.length - (start * 2);
//        int x, y, t;
//        for (int i = 0; i < len - 1; i++) {
//            x = start;
//            y = start + i;
//            for (int j = 0; j < 3; j++) {
//                t = x;
//                x = y;
//                y = matrix.length - t - 1;
//                swap(matrix, start, start + i, x, y);
//            }
//        }
//    }
//
//    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
//        if (x1 == x2 && y1 == y2) {
//            return;
//        }
//        matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
//        matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
//        matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
//    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        LeetCode48 leetCode48 = new LeetCode48();
        leetCode48.rotate(matrix);
        leetCode48.rotate(matrix1);
        System.out.println(ArrayUtils.toString(matrix1));
        System.out.println(ArrayUtils.toString(matrix));
    }
}
