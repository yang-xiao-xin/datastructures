package com.yx.datastructures.linkedlist;

/**
 * 回文链表
 *
 * @author yangxin
 * @date 2021/2/24
 */
public class Palindrom {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);

        NodeFun nodeFun = new NodeFun();
        nodeFun.add(l1);
        nodeFun.add(l2);
        nodeFun.add(l3);
        ListNode head = nodeFun.add(l4);

        Palindrom palindrom = new Palindrom();
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = palindrom.endOfFirstHalf(head);
        ListNode secondHalfStart = palindrom.reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean flag = true;
        while (flag && p2 != null) {
            if (p1.val != p2.val) {
                flag = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = palindrom.reverseList(secondHalfStart);
        System.out.println(flag);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
