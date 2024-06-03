package Throws;

public class MetodaYield {
    public static void main(String[] args) {
        MyTread myThread6 = new MyTread();
        myThread6.start();
        myThread6.setPriority(Thread.MAX_PRIORITY);//care dorim sa fie in prioritet
        Thread.yield();//responsabil de timpul alocat pe actiune
        // trece din running in runnable
        System.out.println("thread main");
    }
}
class MyTread4 extends Thread {
    public void run() {
        System.out.println("tread 0 ");
    }
}
