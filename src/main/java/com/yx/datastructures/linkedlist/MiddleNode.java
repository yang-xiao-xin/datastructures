package com.yx.datastructures.linkedlist;

/**
 * 链表中间节点
 *
 * @author yangxin
 * @date 2021/2/25
 */
public class MiddleNode {
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

        MiddleNode middleNode = new MiddleNode();
        ListNode listNode = middleNode.middleNode(head);
        while(listNode != null){
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    public ListNode middleNode(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            //移动指针
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
