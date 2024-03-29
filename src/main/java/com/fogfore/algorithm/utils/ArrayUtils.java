package com.fogfore.algorithm.utils;

import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayUtils {
    /**
     * 二维数组转字符串
     *
     * @param matrix 二维数组
     * @return 字符串
     */
    public static String toString(int[][] matrix) {
        StringJoiner joiner = new StringJoiner(",\n ", "{", "}");
        for (int i = 0; i < matrix.length; i++) {
            joiner.add(Arrays.toString(matrix[i]));
        }
        return joiner.toString();
    }

    public static String toString(char[][] matrix) {
        StringJoiner joiner = new StringJoiner(",\n ", "{", "}");
        for (int i = 0; i < matrix.length; i++) {
            joiner.add(Arrays.toString(matrix[i]));
        }
        return joiner.toString();
    }

    public static <T> String toString(T[][] matrix) {
        StringJoiner joiner = new StringJoiner(",\n ", "{", "}");
        for (int i = 0; i < matrix.length; i++) {
            joiner.add(Arrays.toString(matrix[i]));
        }
        return joiner.toString();
    }

    public static void swap(int[] array, int src, int dest) {
        if (src == dest) {
            return;
        }
        array[src] = array[src] ^ array[dest];
        array[dest] = array[src] ^ array[dest];
        array[src] = array[src] ^ array[dest];
    }
}
