package com.raptor.base.dayfive;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author raptor
 * @description Solution19
 * @date 2021/12/7 20:27
 */
public class Solution19 {
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int nodes = 0;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode left = head;
        while (left != null) {
            nodes++;
            left = left.next;
        }
        // 正向的第几个
        int target = nodes - n + 1;
        ListNode res = head;
        int i = 1;
        if (target == 1){
            return head.next;
        }
        while (i < target) {
            pre = pre.next;
            res = res.next;
            i++;
        }
        pre.next = res.next;
        return head;
    }

    // 快慢指针  快指针减去满指针 就是n
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //定义虚拟头节点，避免分类讨论
        ListNode dummyNode  = new ListNode(0) ;
        dummyNode.next =head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        int cnt = 0;
        while(cur != null){
            //大于等于n的时候同时移动
            if(cnt >= n){
                pre = pre.next;
            }
            cur = cur.next;
            cnt++;
        }
        pre.next = pre.next.next;
        return dummyNode.next;
    }

    //栈
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        //入队
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 后n个出队
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        // 取pre
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
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
        ListNode listNode = removeNthFromEnd(listNode1, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

