package com.enternal.list;

import java.util.List;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/22  19:49
 */
public class Reverse2List {
    public static ListNode reverse(ListNode root){
        if (root == null || root.next == null){
            return root;
        }
        ListNode l1 = root;
        ListNode l2 = root.next;
        ListNode l3 = reverse(l2.next);
        l2.next = l1;
        l1.next = l3;
        return l2;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverse(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
