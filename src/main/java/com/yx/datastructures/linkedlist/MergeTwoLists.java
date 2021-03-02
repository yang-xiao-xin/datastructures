package com.yx.datastructures.linkedlist;

/**
 * 题目：合并两个链表
 *
 * @author yangxin
 * @date 2021/2/20
 */
public class MergeTwoLists {
    public static void main(String[] args) {

        /**
         * 定义L1链表
         */
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        MergeLinkedList l1 = new MergeLinkedList();
        l1.add(l11);
        l1.add(l12);
        /**
         * 返回新增完的L1链表
         */
        ListNode add1 = l1.add(l13);

        /**
         * 定义L2链表
         */
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        MergeLinkedList l2 = new MergeLinkedList();
        l2.add(l21);
        l2.add(l22);
        /**
         * 返回L2链表
         */
        ListNode add2 = l2.add(l23);

        /**
         * 合并2个单链表
         */
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(add1, add2);

        while (null != listNode) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 如果L1链表为null，终止递归
         */
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        /**
         * 按照图中的描述，两两比较链表的节点
         */
        if (l1.val <= l2.val) {
            /**
             * L1的节点比L2的小，按照图中就是需要比较L1链表的下个节点
             * l1.next 就是指当比较出节点大小后，需要修改指针的指引，将整个链表全部串联起来
             */
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            /**
             * 同理，与上个if判断一样
             */
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

class MergeLinkedList {
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

    /**
     * 遍历节点
     */
    public void printList() {
        // 判断链表是否为空
        if (null == nodeHead.next) {
            System.out.println("链表为空");
        }
        // 遍历节点同样需要一个辅助变量，用来指向下一个节点
        ListNode temp = nodeHead;
        while (null != temp.next) {
            System.out.println(temp.next);
            // 将指针后移，否则会产生死循环
            temp = temp.next;
        }
    }
}

class ListNode {
    /**
     * 数据域
     */
    int val;
    /**
     * 下一个节点指针
     */
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
