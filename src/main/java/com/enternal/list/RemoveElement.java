package com.enternal.list;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/14  22:44
 */
public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        ListNode pre = new ListNode();
        pre.next = cur;
        ListNode ans = pre;
        while (cur!=null){
            if (cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }

        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = new RemoveElement().removeElements(listNode1,1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
