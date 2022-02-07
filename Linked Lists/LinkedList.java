package com.myselfsathya;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();
        if (k <= 0)
            throw new IllegalArgumentException();
        Node a = first;
        Node b = first;
        for(int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                return -1;
        }
        while(b.next != null) {
            b = b.next;
            a = a.next;
        }
        return a.value;
    }

    public void reverse() {
//        if (isEmpty()) return;
//        Node current = first;
//        Node previous = first;
//        Node next = current.next;
//        current.next = null;
//        while(current != null) {
//            current = next;
//            if(current != null) {
//                next = current.next;
//                current.next = previous;
//                previous = current;
//            }
//        }
//        last = first;
//        if (previous != null)
//            first = previous;

        if (isEmpty()) return;
        Node previous = first;
        Node current = first.next;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        int index = 0;
        Node current = first;
        while(current != null) {
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last)
            first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
//        Node temp = first;
//        first = first.next;
//        temp.next = null;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void removeLast() {
        if(first == null)
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            last = getPreviousNode(last);
            last.next = null;
        }
        size--;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while(current != null) {
            if (current.value == item)
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }
}
