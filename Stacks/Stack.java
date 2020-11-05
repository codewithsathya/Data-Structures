package com.myselfsathya;

public class Stack {
    public int[] array = new int[0];

    public void push(int item) {
        int[] temp = new int[array.length + 1];
        for(int i = 0; i < array.length; i++)
            temp[i] = array[i];
        temp[array.length] = item;
        array = temp;
    }

    public int pop() {
        if(isEmpty())
            throw new IllegalStateException();
        int[] temp = new int[array.length - 1];
        for(int i = 0; i < temp.length; i++)
            temp[i] = array[i];
        int result = array[array.length - 1];
        array = temp;
        return result;
    }

    public int peek() {
        return array[array.length - 1];
    }

    public boolean isEmpty() {
        return array.length == 0;
    }
}
