package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;
import com.raptor.hash.TableSizeTest;

import java.sql.SQLOutput;

/**
 * @author raptor
 * @description T148
 * @date 2022/3/23 20:34
 */
public class T148 {
    public ListNode sortList(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        }
        //待排序节点的前一个节点
        ListNode preNone = head;
        //待排序节点
        ListNode none = head.next;
        while (none != null) {
            //记录下要去排序的节点
            preNone.next = none.next;
            System.out.println("当前排序的节点：" + none.val);
            //寻找插入位置
            int val = none.val;

            ListNode preInsert = null;
            //插入位置
            ListNode insert = head;
            print(head);
            while (insert != null) {
                if (val < insert.val) {
                    break;
                }
                preInsert = insert;
                insert = insert.next;
            }
            //这个数是最大的
            if (insert == null) {
                preInsert.next = none;
                none.next = null;
            } else if (preInsert == null) {
                preNone.next = none.next;
                none.next = insert;
                //最小节点
                head = none;
            } else {
                //在中央
                preInsert.next = none;
                none.next = insert;
            }
            //排序节点的下一个节点
            none = head;
            while (none.next != null) {
                if (head.val < none.next.val) {
                    none = none.next;
                } else {
                    break;
                }
            }
            System.out.println("下一个待排节点：" + none.val);
        }
        return head;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(0);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = new T148().sortList(listNode1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
