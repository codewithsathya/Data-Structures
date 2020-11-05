package com.myselfsathya;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public Queue<Integer> reverse(Queue<Integer> queue, int k) {
        int size = queue.size();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }
        for (int i = 0; i < k; i++) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.remove());
        }
        return queue;
    }
}
