package com.enternal.list;


/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/19  18:22
 */
public class ReverseKGroupList {
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
            ListNode[] reverse = reverseList(head, tail);
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


    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = tail.next;
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
        ListNode listNode = new ReverseKGroupList().reverseKGroup(listNode1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
