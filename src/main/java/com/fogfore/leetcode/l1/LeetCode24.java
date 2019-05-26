package com.fogfore.leetcode.l1;

import com.fogfore.algorithm.utils.ListFactory;
import com.fogfore.algorithm.utils.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author fogfore
 */
public class LeetCode24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead, n1 = tempHead.next, n2;
        while (n1 != null && n1.next != null) {
            n2 = n1.next;
            pre.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            pre = n1;
            n1 = n1.next;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListFactory.getList(1, 2, 3, 4);
        System.out.println(swapPairs(head));
    }
}
