package com.tw.concurrency.queue;

import java.util.Arrays;

public class Queue {

    private int[] data;

    public Queue(int... array) {
        this.data = array;
    }

    public Integer pop() {
        int top = data[0];
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
        this.data = Arrays.copyOfRange(data, 1, data.length);
        return top;
    }

    public Integer get(int index) {
        int value = data[index];
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
        return value;
    }

    public int size() {
        return this.data.length;
    }

    public void push(Integer value) {
        int[] cloneData = Arrays.copyOf(data, data.length + 1);
        cloneData[cloneData.length - 1] = value;
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
        this.data = cloneData;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public String toString() {
        String s = "[";
        for(int i=0;i<data.length;i++) {
            s += data[i];
            if(i != data.length - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
