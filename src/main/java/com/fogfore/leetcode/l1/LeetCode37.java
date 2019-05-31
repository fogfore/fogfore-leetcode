package com.fogfore.leetcode.l1;

import com.fogfore.algorithm.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 解数独
 *
 * @author fogfore
 */
public class LeetCode37 {
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length < 9 || board[0].length < 9) {
            return;
        }
        Character[] charSet = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] cellSet = new HashSet[9];
        int count = 81;
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>(Arrays.asList(charSet));
            colSet[i] = new HashSet<>(Arrays.asList(charSet));
            cellSet[i] = new HashSet<>(Arrays.asList(charSet));
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    rowSet[i].remove(board[i][j]);
                    cellSet[i / 3 * 3 + j / 3].remove(board[i][j]);
                    colSet[j].remove(board[i][j]);
                    count -= 3;
                }
            }
        }
        fill(board, rowSet, colSet, cellSet, 0, 0);
    }

    private static boolean fill(char[][] board, Set<Character>[] rowSet, Set<Character>[] colSet, Set<Character>[] cellSet, int i, int j) {
        if (i >= 9) {
            return true;
        }
        if (board[i][j] != '.') {
            i = j == 8 ? i + 1 : i;
            j = (j + 1) % 9;
            return fill(board, rowSet, colSet, cellSet, i, j);
        }

        HashSet<Character> intersection = new HashSet<>(rowSet[i]);
        intersection.retainAll(colSet[j]);
        intersection.retainAll(cellSet[i / 3 * 3 + j / 3]);
        if (intersection.isEmpty()) {
            return false;
        }
        int ti, tj;
        for (Character ch : intersection) {
            rowSet[i].remove(ch);
            cellSet[i / 3 * 3 + j / 3].remove(ch);
            colSet[j].remove(ch);
            ti = i + (j + 1) / 9;
            tj = (j + 1) % 9;
            if (fill(board, rowSet, colSet, cellSet, ti, tj)) {
                board[i][j] = ch;
                return true;
            } else {
                rowSet[i].add(ch);
                colSet[j].add(ch);
                cellSet[i / 3 * 3 + j / 3].add(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        System.out.println(ArrayUtils.toString(board));
    }
}
