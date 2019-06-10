package com.fogfore.leetcode.l2;

/**
 * 单词搜索
 *
 * @author fogfore
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() < 1) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int x, int y, int i) {
        if (word.charAt(i) != board[x][y]) return false;
        visited[x][y] = true;
        i++;
        if (i == word.length()) return true;
        boolean flag = (x > 0 && !visited[x - 1][y] && backtrack(board, word, visited, x - 1, y, i)) ||
                (x < board.length - 1 && !visited[x + 1][y] && backtrack(board, word, visited, x + 1, y, i)) ||
                (y > 0 && !visited[x][y - 1] && backtrack(board, word, visited, x, y - 1, i)) ||
                (y < board[0].length - 1 && !visited[x][y + 1] && backtrack(board, word, visited, x, y + 1, i));
        if (flag) {
            return true;
        } else {
            visited[x][y] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode79 leetCode79 = new LeetCode79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(leetCode79.exist(board, "ABCCED"));
        System.out.println(leetCode79.exist(board, "ABCB"));
    }
}
