package Throws;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueue1 {
    //blocare a firilor
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread() {
            public void run() {
                try {
                    System.out.println(queue.take());//merge in somm
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                queue.add("this is string");//cheama notify
            }
        }.start();
    }
}
