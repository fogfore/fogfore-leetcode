package com.fogfore.leetcode.l1;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 *
 * @author fogfore
 */
public class LeetCode36 {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character>[] sets3 = new HashSet[3];
        for (int i = 0; i < 3; i++) {
            sets3[i] = new HashSet<>();
        }
        // 判断行列
        for (int i = 0; i < 9; i++) {
            set1.clear();
            set2.clear();
            for (int j = 0; j < 9; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    sets3[j / 3].clear();
                }
                if (board[i][j] != '.') {
                    if (set1.contains(board[i][j]) || sets3[j / 3].contains(board[i][j])) {
                        return false;
                    } else {
                        set1.add(board[i][j]);
                        sets3[j / 3].add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (set2.contains(board[j][i])) {
                        return false;
                    } else {
                        set2.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("true " + isValidSudoku(board1));
        System.out.println("false " + isValidSudoku(board2));
    }
}
