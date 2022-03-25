package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

import java.util.HashSet;
import java.util.List;

/**
 * @author raptor
 * @description T141
 * @date 2022/3/23 20:23
 */
public class T141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            System.out.println("当前节点：" + head.val);
            if (set.contains(head)) {

                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        //if (head == null || head.next == null) {
        //    return false;
        //}
        //ListNode slow = head;
        //ListNode fast = head.next;
        //while (slow != fast) {
        //    if (fast == null || fast.next == null) {
        //        return false;
        //    }
        //    slow = slow.next;
        //    fast = fast.next.next;
        //}
        //return true;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode4;
        //listNode4.next = listNode2;
        System.out.println(new T141().hasCycle2(listNode1));
    }
}
