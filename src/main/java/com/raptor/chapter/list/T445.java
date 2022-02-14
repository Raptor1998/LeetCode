package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * @author raptor
 * @description T445
 * @date 2022/2/13 14:01
 */
public class T445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int c = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || c != 0) {
            Integer pop1 = s1.isEmpty() ? 0 : s1.pop();
            Integer pop2 = s2.isEmpty() ? 0 : s2.pop();
            int temp = pop1 + pop2 + c;
            c = temp / 10;
            int real = temp % 10;
            ListNode currNode = new ListNode();
            currNode.val = real;
            currNode.next = head;
            head = currNode;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        HashMap<Object,Object> hashMap = new HashMap<>();

    }
}
