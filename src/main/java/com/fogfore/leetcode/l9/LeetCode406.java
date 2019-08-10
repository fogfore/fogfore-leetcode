package com.fogfore.leetcode.l9;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据身高重建队列
 */
public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 2) return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] < i) {
                int[] temp = people[i];
                int j = i - 1;
                for (; j >= temp[1]; j--) {
                    people[j + 1] = people[j];
                }
                people[j + 1] = temp;
            }
        }
        return people;
    }
}
