package com.raptor.offer.day02;

import com.raptor.base.day5.ListNode;

/**
 * @author raptor
 * @description Offer24
 * @date 2021/12/11 20:21
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Offer24 {
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static ListNode reverseList(ListNode head) {
        return recur(null,head);
    }

    public static ListNode recur(ListNode pre, ListNode curr) {
        if (curr == null) {
            return pre;
        }
        ListNode recur = recur(curr, curr.next);
        curr.next = pre;
        return recur;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseList(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
