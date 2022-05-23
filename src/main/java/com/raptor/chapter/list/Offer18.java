package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

import java.beans.beancontext.BeanContext;

/**
 * @author raptor
 * @description Offer18
 * @date 2022/5/16 14:53
 */
public class Offer18 {
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = new ListNode();
        pre.next = cur;
        ListNode ans = pre;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = deleteNode(listNode1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
