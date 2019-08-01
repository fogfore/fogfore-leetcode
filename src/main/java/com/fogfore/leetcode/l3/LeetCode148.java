package com.fogfore.leetcode.l3;

import com.fogfore.algorithm.utils.ListFactory;
import com.fogfore.algorithm.utils.ListNode;

/**
 * 排序链表
 */
public class LeetCode148 {
    // 归并
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 快慢节点查找中心节点
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode slow = h, fast = h;
        while ((fast = fast.next) != null && (fast = fast.next) != null) {
            slow = slow.next;
        }
        ListNode l1 = sortList(slow.next);
        slow.next = null;
        ListNode l2 = sortList(head);
        ListNode t = h;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                t.next = l1;
                l1 = l1.next;
            } else {
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        return h.next;
    }

    // 快排
//    public ListNode sortList(ListNode head) {
//        quickSort(head, null);
//        return head;
//    }
//
//    public void quickSort(ListNode head, ListNode tail) {
//        if (head == tail) return;
//        ListNode small = head, cur = head.next, temp = head;
//        while (cur != tail) {
//            if (cur.val < temp.val) {
//                small = small.next;
//                swap(small, cur);
//            }
//            cur = cur.next;
//        }
//        swap(temp, small);
//        quickSort(head, small);
//        quickSort(small.next, tail);
//    }

    private void swap(ListNode n1, ListNode n2) {
        if (n1.val == n2.val) return;
        n1.val = n1.val ^ n2.val;
        n2.val = n1.val ^ n2.val;
        n1.val = n1.val ^ n2.val;
    }

    public static void main(String[] args) {
        ListNode list = ListFactory.getList(4, 2, 1, 3);
        LeetCode148 l = new LeetCode148();
        list = l.sortList(list);
        System.out.println(list);
    }
}
