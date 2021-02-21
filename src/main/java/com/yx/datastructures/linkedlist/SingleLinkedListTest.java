package com.yx.datastructures.linkedlist;

/**
 * 第一篇文章：手写单链表
 *
 * @author yangxin
 * @date 2021/2/15
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        CityNode cityNode1 = new CityNode(1, "北京");
        CityNode cityNode2 = new CityNode(2, "上海");
        CityNode cityNode3 = new CityNode(3, "深圳");
        // 新增
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(cityNode1);
        singleLinkedList.add(cityNode2);
        singleLinkedList.add(cityNode3);
    }
}

class SingleLinkedList {
    /**
     * 初始化头指针
     */
    private CityNode nodeHead = new CityNode(0, "");

    public CityNode deleteNode(int num) {
        // 1，定义辅助指针，用来查找下一个节点
        CityNode temp = nodeHead;
        while (true) {
            if (null == temp.next) {
                // 表示链表为空
                break;
            }
            if (temp.next.num == num) {
                // 2，表示已经找到要删除编号的节点，将节点指针指向下下个节点
                temp.next = temp.next.next;
                break;
            }
            // 3，如果都没有找到，则需要将指针向后移动
            temp = temp.next;
        }
        return temp.next;
    }

    /**
     * 按照制定位置添加节点
     */
    public CityNode addOrderNode(CityNode cityNode) {
        // 1，定义辅助指针，用来查找下一个节点
        CityNode temp = nodeHead;
        // 2，循环链表
        while (true) {
            // 先判断是否为链表尾节点
            if (null == temp.next) {
                // 直接添加链表到尾部
                temp.next = cityNode;
                return cityNode;
            }
            // 3，判断如果temp.next指向的节点的编号是大于要新增的节点的编号，那么要插入的位置就找到了
            if (temp.next.num > cityNode.num) {
                break;
            }
            // 4，如果编号相等，表示新增的节点以存在
            if (temp.next.num == cityNode.num) {
                System.out.println("该节点已存在：" + cityNode);
                break;
            }
            // 5，如果当前循环中即没有获取位置，也没有相等的节点，则必须将指针向后移动
            temp = temp.next;
        }
        // 遍历结束，temp.next下一个节点就是要插入的位置
        // 6，将新增节点的next指向temp.next节点
        cityNode.next = temp.next;
        // 7，而此时temp.next就是要添加的新节点
        temp.next = cityNode;
        return cityNode;
    }

    /**
     * 使用尾插法
     */
    public CityNode add(CityNode cityNode) {
        // 1，定义辅助指针
        CityNode temp = nodeHead;
        // 2，首先判断当前节点是否为最后节点
        if (null == temp.next) {
            // 当前节点为最后节点
            temp.next = cityNode;
            return cityNode;
        }
        // 3，循环遍历节点，如果当前节点的下个节点不为空，表示还有后续节点
        while (null != temp.next) {
            // 否则将指针后移
            temp = temp.next;
        }
        // 4，遍历结束，将最后节点的指针指向新添加的节点
        temp.next = cityNode;
        return cityNode;
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
        CityNode temp = nodeHead;
        while (null != temp.next) {
            System.out.println(temp.next);
            // 将指针后移，否则会产生死循环
            temp = temp.next;
        }
    }
}

class CityNode {
    /**
     * 设置编号（不分排名，仅以区分）
     */
    public int num;
    /**
     * 城市名称
     */
    public String cityName;
    /**
     * 定义指针，用来指向下一个节点
     */
    public CityNode next;

    /**
     * 定义构造器
     */
    public CityNode(int num, String cityName) {
        this.num = num;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityNode{" +
                "num=" + num +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}