package com.raptor.chapter.list;

import com.raptor.base.day5.ListNode;

import java.util.UUID;

/**
 * @author raptor
 * @description TBM3
 * @date 2022/3/29 15:09
 */
public class TBM3 {
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(k <= 1) {
            return head;
        }
        if(head == null) {
            return head;
        }
        ListNode node = head;
        int len = length(head);
        head = node;
        int sx = len / k;    //分成sx块向下取整（默认向下） 因为处不尽的后面必然凑不满k个
        ListNode result = new ListNode(0);
        ListNode now = result;
        int cnt = 0;
        for(int i = 0; i < sx; i ++){
            ListNode tmp = null;
            for(int j = 0; j < k; j ++){    //将第i块的元素翻转
                ListNode bl = head.next;
                head.next = tmp;
                tmp = head;
                head = bl;
            }
            now.next = tmp;
            while(now.next != null) {
                now = now.next;    //将now更新到最前的一个点
            }
        }
        now.next = head;
        return result.next;
    }
    public static int length(ListNode now){    //获取链表长度
        int cnt = 0;
        if(now != null) {
            cnt = 1;
        }
        while(now.next != null){
            cnt ++; now = now.next;
        }
        return cnt;
    }

    public static ListNode reverseList(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        int num = 0;
        while (cur != null && num < k) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            num++;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        //return recur(null, head);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    private static ListNode recur(ListNode pre, ListNode head) {
        if (head == null) {
            return pre;
        }
        ListNode t = recur(head, head.next);
        head.next = pre;
        return t;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseKGroup(listNode1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
