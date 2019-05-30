package com.fogfore.leetcode.l1;

import com.fogfore.algorithm.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;

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
        int lastCount = count;
        int num = -1;
        while (true) {
            for (int i = 0; i < 9; i++) {
                next:
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    for (int n = 1; n <= 9; n++) {
                        if (rowSet[i].contains((char) (n + '0')) && colSet[j].contains((char) (n + '0')) && cellSet[i / 3 * 3 + j / 3].contains((char) (n + '0'))) {
                            if (num == -1) {
                                num = n;
                            } else {
                                num = -1;
                                continue next;
                            }
                        }
                    }
                    if (num == -1) {
                        continue;
                    }
                    board[i][j] = (char) (num + '0');
                    rowSet[i].remove((char) (num + '0'));
                    colSet[j].remove((char) (num + '0'));
                    cellSet[i / 3 * 3 + j / 3].remove((char) (num + '0'));
                    num = -1;
                    count--;
                }
            }
            if (count == lastCount) {
                break;
            } else {
                lastCount = count;
            }
        }
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
