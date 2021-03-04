package com.yx.datastructures.linkedlist_medium;

import com.yx.datastructures.common.ListNode;
import com.yx.datastructures.common.ListNodeFun;

/**
 * 两数相加
 *
 * @author yangxin
 * @date 2021/3/3
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        // 创建链表-L1
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        ListNodeFun listNodeFun = new ListNodeFun();
        listNodeFun.add(l1);
        listNodeFun.add(l2);
        ListNode listNode1 = listNodeFun.add(l3);

        ListNodeFun listNodeFun2 = new ListNodeFun();
        // 创建链表-L2
        ListNode l11 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l33 = new ListNode(9);
        listNodeFun2.add(l11);
        listNodeFun2.add(l22);
        ListNode listNode2 = listNodeFun2.add(l33);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;

        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) {
            return null;
        }
        // 初始化头指针
        ListNode head = new ListNode();
        ListNode cur = head;
        // 定义变量保存进位值
        int temp = 0;
        while (null != l1 || null != l2) {
            // 获取每个节点的值
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 两数相加
            int sum = x + y + temp;
            // 获取相加结果
            temp = sum / 10;
            // 获取低位（个位）
            sum = sum % 10;
            // 创建新的节点
            cur.next = new ListNode(sum);
            // 移动指针
            cur = cur.next;
            // 移动链表指针
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (1 == temp) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
