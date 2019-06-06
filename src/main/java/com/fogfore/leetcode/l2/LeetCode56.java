package com.fogfore.leetcode.l2;

import com.fogfore.algorithm.utils.ArrayUtils;

import java.util.*;

/**
 * 合并区间
 *
 * @author fogfore
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length < 1) return res.toArray(new int[0][]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] set = {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > set[1]) {
                res.add(set);
                set = new int[]{intervals[i][0], intervals[i][1]};
            } else {
                set[1] = Math.max(set[1], intervals[i][1]);
            }
        }
        res.add(set);
        return res.toArray(new int[res.size()][]);
    }

//    public int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length < 1) return new int[0][];
//        int[] pres = new int[intervals.length];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < intervals.length; i++) {
//            pres[i] = intervals[i][0];
//            map.put(pres[i], Math.max(map.getOrDefault(pres[i], pres[i]), intervals[i][1]));
//        }
//        Arrays.sort(pres);
//        ArrayList<int[]> res = new ArrayList<>();
//        int[] set = {pres[0], map.get(pres[0])};
//        for (int i = 1; i < pres.length; i++) {
//            if (pres[i] > set[1]) {
//                res.add(set);
//                set = new int[]{pres[i], map.get(pres[i])};
//            } else {
//                set[1] = Math.max(set[1], map.get(pres[i]));
//            }
//        }
//        res.add(set);
//        int[][] resArray = new int[res.size()][];
//        for (int i = 0; i < res.size(); i++) {
//            resArray[i] = res.get(i);
//        }
//        return resArray;
//    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(ArrayUtils.toString(leetCode56.merge(intervals)));
    }
}
