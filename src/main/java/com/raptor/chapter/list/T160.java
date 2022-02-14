package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

/**
 * @author raptor
 * @description T160
 * @date 2022/2/12 19:07
 */
public class T160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }
        return l1;
    }


    public static void main(String[] args) {

    }
}
