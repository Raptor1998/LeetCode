package com.raptor.chapter.bytedance;

import com.raptor.base.day5.ListNode;

public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        ListNode temp = head;
        ListNode start = head;
        ListNode startPre = new ListNode();
        //反转的前置
        startPre.next = start;
        //反转的最后
        ListNode tail = head;
        int index = 1;
        while (temp != null) {
            if (index == left - 1) {
                startPre = temp;
            } else if (index == left) {
                start = temp;
            } else if (index == right) {
                tail = temp;
            }
            index++;
            temp = temp.next;
        }
        if (left == 1) {
            return reverse(head, tail)[0];
        }
        ListNode[] reverse = reverse(start, tail);
        startPre.next = reverse[0];
        return head;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return new ListNode[]{tail, head};
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
        listNode4.next = listNode5;
        ListNode listNode = reverseBetween(listNode1, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
