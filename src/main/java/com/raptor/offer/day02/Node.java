package com.raptor.offer.day02;

/**
 * @author raptor
 * @description Node
 * @date 2021/12/10 21:42
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}