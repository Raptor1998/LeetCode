package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;
import org.junit.Before;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.jar.JarEntry;

/**
 * @author raptor
 * @description T83
 * @date 2022/2/12 20:37
 */
public class T83 {
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode res = head;
        ListNode l1 = head;
        while (head != null) {
            int temp = head.val;
            while (l1.val == temp) {
                l1 = l1.next;
                if (l1 == null) {
                    break;
                }
            }
            head.next = l1;
            head = head.next;
        }
        return res;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = deleteDuplicates(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
