package com.fogfore.leetcode.l1;

import com.fogfore.leetcode.l1.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 *
 * @author fogfore
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((ListNode) o1).val - ((ListNode) o2).val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode end = head;
        ListNode temp;
        while (!queue.isEmpty()) {
            temp = queue.remove();
            end.next = temp;
            end = end.next;
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }
        return head.next;
    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length < 1) {
//            return null;
//        }
//        ListNode head = new ListNode(0);
//        ListNode end = head;
//        ListNode maxNode = new ListNode(Integer.MAX_VALUE);
//        ListNode minNode = maxNode;
//        int minIndex = -1;
//        while (true) {
//            for (int i = 0; i < lists.length; i++) {
//                if (lists[i] != null && lists[i].val < minNode.val) {
//                    minNode = lists[i];
//                    minIndex = i;
//                }
//            }
//            if (minIndex < 0) {
//                break;
//            }
//            end.next = minNode;
//            end = end.next;
//            minNode = maxNode;
//            lists[minIndex] = lists[minIndex].next;
//            minIndex = -1;
//        }
//        return head.next;
//    }
}
