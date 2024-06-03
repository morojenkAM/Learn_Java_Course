package Throws;

public class CreareaFirilorADouaMetoda {
    public static void main(String[] args) throws Exception{
        MyTread myTread2 = new MyTread();
        myTread2.start();//start() ca sa ma introduce intr-un basein

        System.out.println(Thread.currentThread().getName());
        MyRunnable myRunnable = new MyRunnable();

        Thread thread3 = new Thread(myRunnable);
        thread3.start();
    }

    class MyThread2 extends Thread{
        public void run(){

            System.out.println(Thread.currentThread().getName());
        }
    }
    static class MyRunnable implements Runnable{
        public void run(){
            System.out.println(Thread.currentThread().getName());
        }
    }
    //nu ave, garantie care primul se porneste
    //diferenta intre prima si a doua metoda ca noi scrim cu runnable si el trebuie implimentat ca sa fie pornit
}
