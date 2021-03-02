package com.yx.datastructures.linkedlist;

/**
 * 获取链表倒数K个节点
 *
 * @author yangxin
 * @date 2021/2/25
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        NodeFun nodeFun = new NodeFun();
        nodeFun.add(l1);
        nodeFun.add(l2);
        nodeFun.add(l3);
        nodeFun.add(l4);
        ListNode head = nodeFun.add(l5);

        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode listNode = getKthFromEnd.getKthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;

        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        // 先将快指针向前移动K
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
