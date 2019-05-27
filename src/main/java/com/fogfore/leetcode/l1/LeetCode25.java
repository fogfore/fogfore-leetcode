package com.fogfore.leetcode;

import com.fogfore.algorithm.utils.ListFactory;
import com.fogfore.algorithm.utils.ListNode;

/**
 * k个一组翻转链表
 *
 * @author fogfore
 */
public class LeetCode25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode parentHead = new ListNode(0);
        parentHead.next = head;
        ListNode childHead = new ListNode(0);
        ListNode childTail = head;
        ListNode parentTail = parentHead;
        ListNode parentCur = parentHead.next, tempNext;
        int count = 0;
        while (parentCur != null) {
            count++;
            tempNext = parentCur.next;
            parentCur.next = childHead.next;
            childHead.next = parentCur;
            parentCur = tempNext;
            if (count == k) {
                parentTail.next = childHead.next;
                childHead.next = null;
                parentTail = childTail;
                childTail = parentCur;
                count = 0;
            }
        }
        if (count > 0) {
            parentTail.next = reverseKGroup(childHead.next, count);
        }
        return parentHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListFactory.getList(1, 2, 3, 4, 5);
        System.out.println(reverseKGroup(head, 2));
    }
}
