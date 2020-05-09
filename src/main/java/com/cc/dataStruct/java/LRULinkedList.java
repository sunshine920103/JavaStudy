package com.cc.dataStruct.java;

import java.util.Scanner;

/**
 * @author ：cc
 * @date ：created in 2020/5/8 15:58
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class LRULinkedList<T> {

    private Node<T> headNode;

    private int count;

    private int capacity;

    public LRULinkedList(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.headNode = new Node<T>();
    }


    public void addElement(T element) {
        Node node = findPreElement(element);
        if (node != null) {
            deleteElement(node);
        } else if (count >= capacity) {
            deleteEndElement();
        }
        insertBegin(element);
    }


    //找到对应元素的前一个节点
    public Node findPreElement(T element) {
        Node node = headNode;
        while (node.getNext() != null) {
            if (element.equals(node.getNext().getElement()))
                return node;
            node = node.getNext();
        }
        return null;
    }

    //删除该节点指向的下一个节点
    public void deleteElement(Node node) {
        node.setNext(node.getNext().getNext());
        count--;
    }

    public void insertBegin(T element) {
        Node<T> node = new Node<T>(element, this.headNode.getNext());
        headNode.setNext(node);
        count++;
    }

    public void deleteEndElement() {
        if (count == 0) {
            return;
        }
        Node node = headNode;
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        count--;
    }

    public void printAll() {
        Node node = headNode.getNext();
        StringBuilder s = new StringBuilder();
        while (node != null) {
            s.append(node.getElement().toString());
            node = node.getNext();
        }
        System.out.println(s.toString());

    }


    class Node<T> {
        private T element;
        private Node next;

        public Node() {
            this.element = null;
            this.next = null;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList(10);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.addElement(sc.nextInt());
            list.printAll();
        }
    }

}

