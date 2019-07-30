package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.ListNode;
import com.fogfore.algorithm.utils.TreeNode;

/**
 * 环形链表 II
 */
public class LeetCode142 {
    // floyd
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fork = getFork(head);
        if (fork == null) return null;
        ListNode n1 = head, n2 = fork;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    private ListNode getFork(ListNode head) {
        ListNode n1 = head, n2 = head;
        while ((n2 = n2.next) != null && (n2 = n2.next) != null) {
            n1 = n1.next;
            if (n1 == n2) return n1;
        }
        return null;
    }
}
