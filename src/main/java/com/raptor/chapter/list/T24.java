package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

import java.util.Scanner;

/**
 * @author raptor
 * @description T24
 * @date 2022/2/13 11:47
 */
public class T24 {
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l3  = head.next.next;
        l2.next = l1;
        l1.next = swapPairs(l3);
        return l2;
    }
    public static ListNode swapPairs(ListNode head) {
        if(head!=null && head.next!=null){
            ListNode nextNode = head.next;
            head.next = swapPairs(nextNode.next);
            nextNode.next = head;
            return nextNode;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = swapPairs(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
