package Throws;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlock {
    public static void main(String[] args) throws Exception {
        Resource resource2 = new Resource();
        resource2.i = 5;

        MyThread myThread1 = new MyThread(resource2);
        MyThread myThread2 = new MyThread(resource2);

        myThread1.setName("one");
        myThread2.setName("two");

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println(resource2.i);
    }

    static class MyThread extends Thread {
        Resource resource2;

        public MyThread(Resource resource2) {
            this.resource2 = resource2;
        }

        public void run() {
            resource2.changeI();
        }
    }
}

class ResourceK {
    int i;

    Lock lock = new ReentrantLock();

     void changeI() {
         lock.lock();
        int i = this.i;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.currentThread().setName("two");
            Thread.yield();
        }
        i++;
        this.i = i;
        lock.unlock();
    }
}
