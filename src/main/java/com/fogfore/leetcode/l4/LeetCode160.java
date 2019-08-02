package com.fogfore.leetcode.l4;

import com.fogfore.algorithm.utils.ListNode;

/**
 * 相交链表
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    // 笨办法
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) return null;
//        int lenA = 0, lenB = 0;
//        ListNode a = headA, b = headB;
//        while (a != null) {
//            lenA++;
//            a = a.next;
//        }
//        while (b != null) {
//            lenB++;
//            b = b.next;
//        }
//        a = headA;
//        b = headB;
//        while (lenA != lenB) {
//            if (lenA < lenB) {
//                lenA++;
//                b = b.next;
//            }
//            if (lenB < lenA){
//                lenB++;
//                a = a.next;
//            }
//        }
//        while (a != null && a != b) {
//            a = a.next;
//            b = b.next;
//        }
//        return a;
//    }
}
