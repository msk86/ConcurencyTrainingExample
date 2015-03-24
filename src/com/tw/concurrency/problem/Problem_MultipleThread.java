package com.tw.concurrency.problem;

import com.tw.concurrency.queue.Queue;

public class Problem_MultipleThread implements Runnable {

    private final int threadNum;
    private Queue queue;

    public Problem_MultipleThread(int threadNum, Queue queue) {
        this.threadNum = threadNum;
        this.queue = queue;
    }

    public void run() {
        for(int i=0;i<queue.size();i++) {
            System.out.println("Get " + queue.get(i) + " from " + i);
        }

        while(true) {
            if(queue.isEmpty()) {
                break;
            }
            int top = queue.pop();
            System.out.println("Pop " + top + " from thread " + threadNum);
        }
        System.out.println("Thread " + threadNum + " Process done.");
    }


    public static void main(String[] args) {
        Queue queue = new Queue(1,2,3,4,5,6,7);
        new Thread(new Problem_MultipleThread(1, queue)).start();
        new Thread(new Problem_MultipleThread(2, queue)).start();
        new Thread(new Problem_MultipleThread(3, queue)).start();
    }
}