package com.fogfore.leetcode.l5;

import com.fogfore.algorithm.utils.ListNode;

/**
 * 反转链表
 */
public class LeetCode206 {
    // 迭代
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode h = head, next = head.next;
//        h.next = null;
//        while (next != null) {
//            ListNode t = next.next;
//            next.next = h;
//            h = next;
//            next = t;
//        }
//        return h;
//    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
