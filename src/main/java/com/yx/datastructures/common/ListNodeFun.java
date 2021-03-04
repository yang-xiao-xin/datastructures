package com.yx.datastructures.common;

/**
 * @author yangxin
 * @date 2021/3/3
 */
public class ListNodeFun {
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
