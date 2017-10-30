package com.company.test;

/**
 * Created by wutengfei on 2017/10/14.
 */
public class SingleList {

    private static class Node {
        private int data;   //数据区
        private Node next;   //指针区

        Node(int data) {
            this.data = data;
        }
    }

    private Node head; //头节点

    /**
     * 添加节点
     *
     * @param data 插入的数据
     */
    private void addNode(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 删除第n个节点
     *
     * @param index 节点位置
     * @return 成功为true，失败为false
     */
    private boolean deleteNode(int index) {
        if (index < 1 || index > length())//删除元素位置不合理
            return false;
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * @return 节点的长度
     */
    private int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 返回第n个节点
     *
     * @param index 索引
     * @return 第n个节点
     */
    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 链表排序  升序
     *
     * @return 排序后的头结点
     */
    private Node orderList() {
        Node nextNode;
        int temp;
        Node curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    //输出链表
    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.addNode(3);
        list.addNode(1);
        list.addNode(5);
        list.addNode(2);
        list.addNode(4);
        System.out.println("before order");
        list.printList();

        list.orderList();
        System.out.println("after order");
        list.printList();

        list.deleteNode(2);
        System.out.println("删除第二个数据");
        list.printList();

        System.out.println("list的第4个数据的值是" + list.getNode(4).data);
    }

}
