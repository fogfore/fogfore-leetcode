package com.fogfore.leetcode.l5;

import com.fogfore.algorithm.utils.ListNode;

import java.util.List;

public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head.next;
        ListNode pre = null, temp = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp.next = pre;
            pre = temp;
        }
        ListNode l2 = slow.next;
        slow.next = pre;
        ListNode l1 = fast == null ? slow.next : slow;
        while (l1 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
