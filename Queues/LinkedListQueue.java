package com.myselfsathya;

import java.util.LinkedList;

public class LinkedListQueue {
    private LinkedList<Integer> list = new LinkedList<>();

    public void enqueue(int item) {
        list.addLast(item);
    }

    public int dequeue() {
        return list.removeFirst();
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
