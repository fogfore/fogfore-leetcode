package com.fogfore.leetcode.l7;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class LeetCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums == null || nums.length < 1 || k < 1) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        priorityQueue.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode347 l = new LeetCode347();
        System.out.println(l.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
        System.out.println(l.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
