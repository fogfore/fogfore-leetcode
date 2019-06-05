package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.ListFactory;
import com.fogfore.algorithm.utils.ListNode;

/**
 * 环形链表
 *
 * @author fogfore
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        LeetCode141 leetCode141 = new LeetCode141();
//        System.out.println(leetCode141.hasCycle(ListFactory.getList(3, 2, 0, -4)));
    }
}
