package com.fogfore.leetcode.l2;

/**
 * 最小路径和
 *
 * @author fogfore
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0 && i != 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j != 0) {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        LeetCode64 leetCode64 = new LeetCode64();
        System.out.println(leetCode64.minPathSum(grid));
    }
}
