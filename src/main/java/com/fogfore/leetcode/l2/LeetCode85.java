package com.fogfore.leetcode.l2;

import java.util.LinkedList;

/**
 * 最大矩形
 *
 * @author fogfore
 */
public class LeetCode85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int[] array = new int[matrix[0].length];
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            stack.clear();
            stack.addFirst(-1);
            for (int j = 0; j < matrix[0].length; j++) {
                array[j] = matrix[i][j] == '0' ? 0 : array[j] + 1;
                while (stack.peekFirst() != -1 && array[j] < array[stack.peekFirst()]) {
                    int cur = stack.removeFirst();
                    max = Math.max(max, array[cur] * (j - stack.peekFirst() - 1));
                }
                if (stack.peekFirst() != j) stack.addFirst(j);
            }
            while (stack.peekFirst() != -1) {
                int cur = stack.removeFirst();
                max = Math.max(max, array[cur] * (matrix[0].length - stack.peekFirst() - 1));
            }
        }
        return max;
    }

//    public int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
//        int[] array = new int[matrix[0].length];
//        LinkedList<Peer> queue = new LinkedList<>();
//        int max = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            queue.clear();
//            for (int j = 0; j < matrix[0].length; j++) {
//                array[j] = matrix[i][j] == '0' ? 0 : array[j] + 1;
//                max = Math.max(max, array[j]);
//                if (!queue.isEmpty()) {
//                    for (Peer peer : queue) {
//                        int minHeight = Math.min(peer.v, array[j]);
//                        max = Math.max(minHeight * (j - peer.i + 1), max);
//                    }
//                }
//
//                if (queue.isEmpty() || array[j] > queue.peekLast().v) {
//                    queue.addLast(new Peer(array[j], j));
//                } else {
//                    int t = j;
//                    while (!queue.isEmpty()) {
//                        if (array[j] <= queue.peekLast().v) {
//                            t = queue.peekLast().i;
//                            queue.removeLast();
//                        } else {
//                            break;
//                        }
//                    }
//                    queue.addLast(new Peer(array[j], t));
//                }
//            }
//        }
//        return max;
//    }
//
//    class Peer {
//        int v;
//        int i;
//
//        public Peer(int v, int i) {
//            this.v = v;
//            this.i = i;
//        }
//    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] matrix1 = {
                {'0'}
        };
        LeetCode85 leetCode85 = new LeetCode85();
        System.out.println(leetCode85.maximalRectangle(matrix));
        System.out.println(leetCode85.maximalRectangle(matrix1));
    }
}
