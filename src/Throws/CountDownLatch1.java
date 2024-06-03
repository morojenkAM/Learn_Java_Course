package Throws;

import java.util.concurrent.CountDownLatch;
public class CountDownLatch1 {
    //multe fire care dorim sa faca nista lucrui si dupa dorim sa le folosim
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); /* de cate ori dorim sa se efectueze */

        new Worker(countDownLatch);
        new Worker(countDownLatch);
        new Worker(countDownLatch);

        countDownLatch.await();
        System.out.println("all job done");
    }
}

class Worker extends Thread {
    CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }
    public void run(){
        try {
            sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("done wor");
        countDownLatch.countDown();
    }
}