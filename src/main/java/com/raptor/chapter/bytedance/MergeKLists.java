package com.raptor.chapter.bytedance;

import com.raptor.base.day5.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raptor
 * @description MergeKLists
 * @date 2022/4/12 14:46
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        ListNode list1 = lists[0];
        for (int i = 1; i < n; i++) {
            ListNode list2 = lists[i];
            list1 = mergeTwoLists(list1, list2);
        }
        return list1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(0);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(8);


        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        listNode7.next = listNode8;
        ListNode[] lists = {listNode1, listNode4, listNode7};
        ListNode listNode = new MergeKLists().mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
