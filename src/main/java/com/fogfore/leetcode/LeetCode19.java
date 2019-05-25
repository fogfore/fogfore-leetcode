package com.fogfore.leetcode;

import java.util.List;

/**
 * 删除链表的倒数第N个节点
 *
 * @author fogfore
 */
public class LeetCode19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead, next = tempHead;
        int count = 0;
        while (next.next != null) {
            if (count >= n) {
                pre = pre.next;
            }
            next = next.next;
            count++;
        }
        pre.next = pre.next.next;
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head, 1));
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
