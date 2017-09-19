package com.company.test;

/**
 * 已知二叉树的前序遍历和中序遍历，输出后序遍历
 */

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private char data;

        public Node(char data) {
            this.data = data;
        }
    }

    public BinaryTree() {
    }

    public void initTree(char[] preOrder, char[] inOrder) {
        this.root = this.initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public Node initTree(char[] preOrder, int start1, int end1, char[] inOrder, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        char rootData = preOrder[start1];
        Node head = new Node(rootData);
        //找到根节点所在位置
        int rootIndex = findIndexInArray(inOrder, rootData, start2, end2);
        //构建左子树
        Node left = initTree(preOrder, start1 + 1, start1 + rootIndex - start2, inOrder, start2, rootIndex - 1);
        //构建右子树
        Node right = initTree(preOrder, start1 + rootIndex - start2 + 1, end1, inOrder, rootIndex + 1, end2);
        head.left = left;
        head.right = right;
        return head;
    }

    public int findIndexInArray(char[] a, char x, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //后序遍历方法递归实现
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入前序遍历");
        String pre = scanner.nextLine();//GDAFEMHZ
        System.out.println("请输入中序遍历");
        String in = scanner.nextLine();//ADEFGHMZ
        char[] preOrder = pre.toCharArray();
        char[] inOrder = in.toCharArray();
        BinaryTree biTree = new BinaryTree();
        biTree.initTree(preOrder, inOrder);
        System.out.println("二叉树的后序遍历是:");
        biTree.postOrder();//A E F D H Z M G
    }
}