package com.fogfore.leetcode.l4;

import java.util.LinkedList;

/**
 * 乘积最大子序列
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int n : nums) {
            if (n < 0) {
                imax = imax ^ imin;
                imin = imax ^ imin;
                imax = imax ^ imin;
            }
            imax = Math.max(imax * n, n);
            imin = Math.min(imin * n, n);
            max = Math.max(max, imax);
        }
        return max;
    }
    // 笨办法
//    public int maxProduct(int[] nums) {
//        if (nums == null || nums.length < 1) return 0;
//        LinkedList<Integer> stackSign = new LinkedList();
//        LinkedList<Integer> stackElem = new LinkedList();
//        int max = Integer.MIN_VALUE;
//        int cur = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                max = Math.max(max, clear(stackSign, stackElem, cur));
//            } else if (nums[i] < 0) {
//                stackSign.push(nums[i]);
//                stackElem.push(cur);
//            }
//            cur = nums[i] <= 0 ? nums[i] : cur * nums[i];
//            max = Math.max(cur, max);
//            cur = cur <= 0 ? 1 : cur;
//        }
//        max = Math.max(max, clear(stackSign, stackElem, cur));
//        return max;
//    }
//
//    private int clear(LinkedList<Integer> stackSign, LinkedList<Integer> stackElem, int base) {
//        if (stackSign.isEmpty()) return Integer.MIN_VALUE;
//        int cur2 = stackElem.pop();
//        int cur1 = stackSign.pop() * cur2 * base;
//        int m = Integer.MIN_VALUE;
//        while (!stackSign.isEmpty()) {
//            int t = stackElem.pop() * stackSign.pop();
//            cur1 *= t;
//            cur2 *= t;
//            m = Math.max(m, Math.max(cur1, cur2));
//        }
//        return m;
//    }

    public static void main(String[] args) {
        LeetCode152 l = new LeetCode152();
        System.out.println(l.maxProduct(new int[]{3, -2, -3, 3, -1, 0, 1}));
        System.out.println(l.maxProduct(new int[]{3, -2, -3, -3, 1, 3, 0}));
        System.out.println(l.maxProduct(new int[]{2, -5, -2, -4, 3}));
        System.out.println(l.maxProduct(new int[]{-2, -3, 7}));
        System.out.println(l.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(l.maxProduct(new int[]{-2, 0, -1}));
    }
}
