package com.fogfore.leetcode.l61;

/**
 * 旋转链表
 */
public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        ListNode tail = head;
        while (cur != null) {
            count++;
            tail = cur;
            cur = cur.next;
        }
        if (count < 2 || k % count == 0) {
            return head;
        }
        int len = count - k % count;
        cur = head;
        while (len > 1) {
            cur = cur.next;
            len--;
        }
        ListNode nhead = cur.next;
        cur.next = null;
        tail.next = head;
        return nhead;
    }
}
