package com.myselfsathya;

import java.util.Arrays;
import java.util.LinkedList;

class Entry {
    public int key;
    public String value;

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTable {
    private LinkedList<Entry>[] array;
    private final int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        array = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        int index = hash(key);
        if(array[index] == null)
            array[index] = new LinkedList<>();
        for(Entry e : array[index])
            if(e.key == key) {
                e.value = value;
                return;
            }
        array[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hash(key);
        for(Entry e : array[index])
            if(e.key == key)
                return e.value;
        return null;
    }

    public String remove(int key) {
        int index = hash(key);
        for(Entry e : array[index]){
            if(e.key == key) {
                String value = e.value;
                array[index].remove(e);
                return value;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % capacity;
    }
}
