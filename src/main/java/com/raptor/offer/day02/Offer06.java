package com.raptor.offer.day02;

import com.raptor.base.day5.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author raptor
 * @description Offer06
 * @date 2021/12/10 17:11
 */
public class Offer06 {
    public static int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
        }
        return ints;
    }

    public static int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }

    static List<Integer> tmp = new ArrayList<>();

    public static int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    private static void recur(ListNode head) {

        if (head == null) {
            return;
        }
        System.out.println("当前head的值："+head.val);
        recur(head.next);
        tmp.add(head.val);
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
        int[] ints = reversePrint(listNode1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
