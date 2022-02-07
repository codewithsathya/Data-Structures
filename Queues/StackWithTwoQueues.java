package com.myselfsathya;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private boolean reference = true;

    public void push(int item) {
        Queue<Integer> first = (reference) ? queue1 : queue2;
        first.add(item);
    }

    public int pop() {
        Queue<Integer> first = (reference) ? queue1 : queue2;
        Queue<Integer> second = (!reference) ? queue1 : queue2;
        int temp;
        while(true) {
            temp = first.remove();
            if(first.isEmpty())
                break;
            second.add(temp);
        }
        reference = !reference;
        return temp;
    }

    @Override
    public String toString() {
        Queue<Integer> first = (reference) ? queue1 : queue2;
        return first.toString();
    }
}
