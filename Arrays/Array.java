package com.myselfsathya;

public class Array {
    private int[] items;
    public int length;
    private int count;

    public Array(int length) {
        this.length = length;
        items = new int[length];
    }

    public void reverse() {
        int[] temp = new int[count];
        if (count >= 0) System.arraycopy(items, 0, temp, 0, count);
        for (int i = 0; i < count; i++)
            items[i] = temp[count - i - 1];
    }

    public int max() {
        int max = 0;
        for (int i = 0; i < count; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++)
            if (value == items[i])
                return i;
        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public void insert(int item) {
        if (count == length) {
            int[] temp = new int[count + 2];
            for (int i = 0; i < count; i++)
                temp[i] = items[i];
            items = temp;
        }
        items[count++] = item;
    }

    public void print() {
        for(int i = 0; i < count; i++)
            System.out.print(items[i] + " ");
        System.out.println();
    }
}
