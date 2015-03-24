package com.tw.concurrency.problem;

import com.tw.concurrency.queue.Queue;

public class Problem_SingleThread implements Runnable {

    private Queue queue;

    public Problem_SingleThread(Queue queue) {
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
            System.out.println("Pop " + top);
        }
        System.out.println("Process done.");
    }


    public static void main(String[] args) {
        Queue queue = new Queue(1,2,3);
        new Thread(new Problem_SingleThread(queue)).start();
    }
}