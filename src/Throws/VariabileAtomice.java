package Throws;

import java.util.concurrent.atomic.AtomicInteger;

public class VariabileAtomice {

    static AtomicInteger atomicInteger = new AtomicInteger();//sciocic atomic


    public static void main(String[] args) throws Exception {
        for (int j = 0;j < 10000;j++){
            new MyThread().start();
        }
        Thread.sleep(100);
        System.out.println(atomicInteger.get());
    }
    static class MyThread extends Thread{
        public void run(){
            atomicInteger.incrementAndGet();
        }
    }

}
