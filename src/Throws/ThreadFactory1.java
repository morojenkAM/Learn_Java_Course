package Throws;

import java.util.concurrent.ThreadFactory;

public class ThreadFactory1 {
    public static void main(String[] args) throws Exception {
        //lucru ca sa le faci unice
        ThreadFactory threadFactory = new ThreadFactory() {
            public Thread newThread(Runnable r){
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        threadFactory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable{
        public void run(){
            System.out.println(1);
        }
    }
}
