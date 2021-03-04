package com.yx.datastructures.common;

/**
 * @author yangxin
 * @date 2021/3/3
 */
public class ListNode {
    /**
     * 数据域
     */
    public int val;
    /**
     * 下一个节点指针
     */
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
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
