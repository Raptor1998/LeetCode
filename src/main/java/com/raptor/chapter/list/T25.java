package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;
import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * @author raptor
 * @description T25
 * @date 2022/4/6 17:18
 */
public class T25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            //寻找尾部指针
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            //记录下一次的起始点
            ListNode next = tail.next;
            //翻转部分链表   得到 反转后的  头指针 和 尾指针
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            //当前部分的头尾 指针  修改
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public void show(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
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
        //ListNode listNode = new T25().reverseKGroup(listNode1, 2);
        ListNode listNode = new T25().reverse(listNode1, listNode3)[0];
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
