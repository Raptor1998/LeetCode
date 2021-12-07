package com.raptor.base.dayfive;

import javax.xml.ws.Holder;

/**
 * @author raptor
 * @description Solution876
 * @date 2021/12/7 19:50
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Solution876 {


    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!= null) {
            System.out.println("当前slow："+slow.val);
            System.out.println("当前fast："+fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = middleNode(listNode1);
        System.out.println(listNode.val);
    }


}

