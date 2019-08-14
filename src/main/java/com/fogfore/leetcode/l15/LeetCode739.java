package com.fogfore.leetcode.l15;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 每日温度
 */
public class LeetCode739 {
    // 优化
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!list.isEmpty() && T[list.peek()] < T[i]) {
                int t = list.pop();
                res[t] = i - t;
            }
            list.push(i);
        }
        return res;
    }

    // 暴力
//    public int[] dailyTemperatures(int[] T) {
//        int[] res = new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            for (int j = i + 1; j < T.length; j++) {
//                if (T[j] > T[i]) {
//                    res[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        LeetCode739 leetCode739 = new LeetCode739();
        System.out.println(Arrays.toString(leetCode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
