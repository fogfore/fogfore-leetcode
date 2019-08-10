package com.fogfore.leetcode.l8;

import java.util.*;

/**
 * 除法求值
 */
public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> matrix = new HashMap<>();
        buildMatrix(matrix, equations, values);
        double[] res = new double[queries.size()];
        int count = 0;
        for (List<String> list : queries) {
            res[count] = dfs(matrix, list.get(0), list.get(1), new HashSet<>());
            count++;
        }
        return res;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> matrix, String src, String dest, HashSet<String> visited) {
        if (!matrix.containsKey(src)) return -1.0;
        if (matrix.get(src).containsKey(dest)) return matrix.get(src).get(dest);
        visited.add(src);
        for (Map.Entry<String, Double> entry : matrix.get(src).entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double t = dfs(matrix, entry.getKey(), dest, visited);
                if (t != -1) return t * entry.getValue();
            }
        }
        return -1.0;
    }

    private void buildMatrix(HashMap<String, HashMap<String, Double>> matrix, List<List<String>> equations, double[] values) {
        int count = 0;
        for (List<String> list : equations) {
            if (!matrix.containsKey(list.get(0))) {
                matrix.put(list.get(0), new HashMap<>());
            }
            matrix.get(list.get(0)).put(list.get(1), values[count]);
            if (!matrix.containsKey(list.get(1))) {
                matrix.put(list.get(1), new HashMap<>());
            }
            matrix.get(list.get(1)).put(list.get(0), 1.0 / values[count]);
            count++;
        }
    }
}
