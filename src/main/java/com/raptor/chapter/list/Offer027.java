package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

/**
 * @author raptor
 * @description Offer027
 * @date 2022/3/23 20:15
 */
public class Offer027 {
    public boolean isPalindrome(ListNode head) {
        StringBuffer s = new StringBuffer();
        while (head != null) {
            s.append(head.val);
            head = head.next;
        }
        String temp = s.toString();
        StringBuffer rev = s.reverse();
        return temp.equals(rev.toString());
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(new Offer027().isPalindrome(listNode1));
    }
}
