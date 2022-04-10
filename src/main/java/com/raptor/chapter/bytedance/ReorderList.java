package com.raptor.chapter.bytedance;

import com.raptor.base.day5.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReorderList {
    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        int n = stack.size();
        ListNode cur = head;
        int index = 0;
        while (index < n / 2) {
            ListNode next = cur.next;
            ListNode pop = stack.pop();
            cur.next = pop;
            pop.next = next;
            cur = next;
            index++;
            if (index == n / 2) {
                cur.next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;


        reorderList(listNode1);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
