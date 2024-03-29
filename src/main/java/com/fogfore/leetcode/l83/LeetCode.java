package com.fogfore.leetcode.l83;

/**
 * 删除排序链表中的重复元素
 */
public class LeetCode {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

