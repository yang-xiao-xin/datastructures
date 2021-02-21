package com.yx.datastructures.linkedlist;

/**
 * 题目：删除重复节点
 *
 * @author yangxin
 * @date 2021/2/21
 */
public class DeleteDuplicates {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);

        NodeFun nodeFun = new NodeFun();
        nodeFun.add(l1);
        nodeFun.add(l2);
        nodeFun.add(l3);
        nodeFun.add(l4);
        nodeFun.add(l5);
        ListNode listNode = nodeFun.add(l6);

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(listNode);
        while (null != listNode) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 定义辅助指针
         */
        ListNode temp = head;
        /**
         * 判断当前节点和下一个节点不能为空，因为是需要将当前节点和下一个节点进行比较的
         */
        while (temp != null && temp.next != null) {
            /**
             * 如果节点值相同
             */
            if (temp.val == temp.next.val) {
                /**
                 * 表示当前节点与下一个节点的值相同，则移动指针
                 */
                temp.next = temp.next.next;
            } else {
                /**
                 * 必须移动指针，否则会产生死循环
                 */
                temp = temp.next;
            }
        }
        return head;
    }
}

class NodeFun {
    /**
     * 初始化头指针
     */
    private ListNode nodeHead = new ListNode(0);

    /**
     * 使用尾插法
     */
    public ListNode add(ListNode node) {
        // 1，定义辅助指针
        ListNode temp = nodeHead;
        // 2，首先判断当前节点是否为最后节点
        if (null == temp.next) {
            // 当前节点为最后节点
            temp.next = node;
            return nodeHead;
        }
        // 3，循环遍历节点，如果当前节点的下个节点不为空，表示还有后续节点
        while (null != temp.next) {
            // 否则将指针后移
            temp = temp.next;
        }
        // 4，遍历结束，将最后节点的指针指向新添加的节点
        temp.next = node;
        return nodeHead.next;
    }
}

