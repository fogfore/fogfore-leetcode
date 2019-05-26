package com.fogfore.algorithm.utils;

public class ListFactory {
    public static ListNode getList(int... values) {
        ListNode head = new ListNode(0);
        ListNode end = head;
        for (int v : values) {
            end.next = new ListNode(v);
            end = end.next;
        }
        return head.next;
    }
}
