package com.yx.datastructures.linkedlist_medium;


import com.yx.datastructures.common.ListNode;
import com.yx.datastructures.common.ListNodeFun;

/**
 * 节点两两交换
 *
 * @author yangxin
 * @date 2021/3/3
 */
public class SwapPairs {
    public static void main(String[] args) {
        // 创建链表
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
        ListNode head = listNodeFun.add(l5);

        SwapPairs swap = new SwapPairs();
        ListNode listNode = swap.swapPairs(head);
        while(listNode != null){
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
}
