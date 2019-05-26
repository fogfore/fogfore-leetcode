package com.fogfore.leetcode.l1;

import com.fogfore.algorithm.utils.ListNode;

/**
 * 合并两个有序链表
 *
 * @author fogfore
 */
public class LeetCode21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode end = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }
        if (l1 != null) {
            end.next = l1;
        } else {
            end.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//
//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
//}