package com.raptor.base.day5;

/**
 * @author raptor
 * @description ListNode
 * @date 2021/12/7 20:27
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}