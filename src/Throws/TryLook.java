package Throws;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLook {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException{
        new ThreadM().start();
        new ThreadD().start();
    }

    static class ThreadM extends Thread{
        public void run(){
            lock.lock();
            System.out.println(getName() + "start working");
            try{
                sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(getName() + "stop working");
            lock.unlock();
            System.out.println(getName() + "lock is relaesed");
        }
    }

    static class ThreadD extends Thread{
        public void run(){
            System.out.println(getName() + "begin working");
            while(true){

                if (lock.tryLock()){
                    System.out.println(getName() + "working");
                    break;
                }else {
                    System.out.println(getName() + "waiting");
                }
            }
        }
    }
}
