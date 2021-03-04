package com.yx.datastructures.linkedlist_medium;

import com.yx.datastructures.common.ListNode;
import com.yx.datastructures.common.ListNodeFun;

/**
 * @author yangxin
 * @date 2021/3/3
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        // 创建链表-L1
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        ListNodeFun listNodeFun = new ListNodeFun();
        listNodeFun.add(l1);
        listNodeFun.add(l2);
        listNodeFun.add(l3);
        listNodeFun.add(l4);
        ListNode listNode = listNodeFun.add(l5);

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode nthFromEnd = removeNthFromEnd.removeNthFromEnd(listNode, 2);
        while (nthFromEnd != null) {
            System.out.println(nthFromEnd);
            nthFromEnd = nthFromEnd.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        // 定义双指针
        ListNode slow = pre;
        ListNode fast = head;
        // 先将快指针移动n个节点
        while (--n > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
