package com.yx.datastructures.linkedlist;

/**
 * 题目：环形链表
 *
 * @author yangxin
 * @date 2021/2/21
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        /**
         * 给主角加个环
         */
        l4.next = l2;

        NodeFun nodeFun = new NodeFun();
        nodeFun.add(l1);
        nodeFun.add(l2);
        nodeFun.add(l3);
        ListNode listNode = nodeFun.add(l4);

        HasCycle hasCycle = new HasCycle();
        boolean b = hasCycle.hasCycle(listNode);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        if (null == head) {
            // 为空表示没有环
            return false;
        }
        // 定义慢指针
        ListNode slow = head;
        // 定义快指针
        ListNode fast = head.next;
        // 循环，只要2个指针不重合，就一直循环
        while (slow != fast) {
            // 如果2个指针都到达尾节点，表示没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 否则就移动指针
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
