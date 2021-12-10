package com.raptor.offer.day02;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author raptor
 * @description Offer35
 * @date 2021/12/10 21:42
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class Offer35 {

    /**
     * 深拷贝
     * 不知道链表结构的情况下，复制链表
     */
    static Map<Node, Node> cache = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        while (!cache.containsKey(head)) {
            Node temp = new Node(head.val);
            cache.put(head, temp);
            temp.next = copyRandomList(head.next);
            temp.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);

        Node node2 = new Node(13);

        Node node3 = new Node(11);

        Node node4 = new Node(10);

        Node node5 = new Node(1);
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

    }
}
