package com.fogfore.leetcode.l2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * @author fogfore
 */
public class LeetCode78 {
    // 回溯
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    // 循环
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        res.add(new LinkedList<>());
//        if (nums == null || nums.length < 1) return res;
//        List<List<Integer>> temp = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            temp.clear();
//            for (List<Integer> list : res) {
//                List<Integer> t = new LinkedList<>(list);
//                t.add(nums[i]);
//                temp.add(t);
//            }
//            res.addAll(temp);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        System.out.println(leetCode78.subsets(new int[]{1, 2, 3}));
    }
}
