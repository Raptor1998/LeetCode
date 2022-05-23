package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

import java.awt.*;

/**
 * @author raptor
 * @description T92
 * @date 2022/4/7 15:04
 */
public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right){
            return head;
        }

        int index = 0;
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        pre.next = cur;
        ListNode st = null;
        ListNode end = null;
        ListNode preSt = new ListNode(0);
        while (cur != null) {
            index++;
            if (index == left - 1) {
                preSt = cur;
            } else if (index == left) {
                st = cur;
            } else if (index == right) {
                end = cur;
            }
            cur = cur.next;
        }

        if (left == 1) {
            return reverse(head, end)[0];
        }

        ListNode[] reverse = reverse(st, end);
        preSt.next = reverse[0];
        return pre.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return new ListNode[]{tail, head};
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
        ListNode listNode = new T92().reverseBetween(listNode1, 1, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
