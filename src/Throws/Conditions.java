package Throws;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conditions {
    static Lock lock = new ReentrantLock();
    //pentru ce avem nevoie conditions
    //sa signalizam si sa asteptam anumite conditii si sa dam de stire ca ceva a sosit

    static Condition condition = lock.newCondition();
    static int account = 0;

    public static void main(String[] args) {
new AccountMinus().start();
new AccountPlus().start();
    }
    static class AccountPlus extends Thread{
        public void run(){
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread{
        public void run(){
            if (account < 10){
                try {
                    lock.lock();
                    System.out.println("account = "+ account );
                    condition.await();
                    System.out.println( "account = "+ account);
                    lock.unlock();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            account -= 10;
            System.out.println("account at the end = " + account);
        }
    }

}
