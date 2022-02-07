package com.myselfsathya;
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> enqStack = new Stack<>();
    private Stack<Integer> deqStack = new Stack<>();

    public void enqueue(int item) {
        moveStacks(deqStack, enqStack);
        enqStack.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        moveStacks(enqStack, deqStack);
        return deqStack.pop();
    }

    public boolean isEmpty() {
        return enqStack.isEmpty() && deqStack.isEmpty();
    }

    private void moveStacks(Stack<Integer> from, Stack<Integer> to) {
        while(!from.isEmpty())
            to.push(from.pop());
    }
}
