package com.raptor.base.dayfive;

/**
 * @author raptor
 * @description ListNode
 * @date 2021/12/7 20:27
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}