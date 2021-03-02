package com.yx.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 *
 * @author yangxin
 * @date 2021/2/23
 */
public class ReverseList {
    public static void main(String[] args) {
        // 创建单链表
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
        // 返回创建的链表
        ListNode node = nodeFun.add(l5);

        ReverseList reverseList = new ReverseList();
       /* ListNode listNode = reverseList.reverseListIteration(node);

        while (listNode != null) {
            // System.out.println(listNode);
            listNode = listNode.next;
        }*/

        ListNode listRecursion = reverseList.reverseListIteration(node);

        while (listRecursion != null) {
            System.out.println(listRecursion);
            listRecursion = listRecursion.next;
        }
    }

    public ListNode reverseListIteration(ListNode head) {
        // 定义上节点辅助指针
        ListNode pre = null;
        // 定义当前节点辅助指针
        ListNode cur = head;
        // 循环当前节点不为空
        while (null != cur) {
            // 临时变量保存当前节点的下个节点
            ListNode temp = cur.next;
            // 当前节点的next指向上节点
            cur.next = pre;
            // 上节点向下移动
            pre = cur;
            // 当前节点指向下个节点
            cur = temp;
        }
        return pre;
    }

    ListNode temp = null;

    public ListNode reverseListRecursion(ListNode head) {
        if (head != null) {
            // 获取下一个节点
            ListNode nextNode = head.next;
            // 将下个节点放在临时节点中
            head.next = temp;
            // 判断是否还有下一个节点，使用递归判断，没有则直接返回链表
            if (nextNode != null) {
                // 将放在临时节点中的节点置为head
                temp = head;
                return reverseListRecursion(nextNode);
            }
        }
        return head;
    }
}
