package Throws;

public class CreareaFirilorPrimaMetoda {
    public static void main(String[] args ) throws Exception {
    MyTread myTread = new MyTread();
    myTread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class MyTread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("MyTread run new");
        someMethod();
    }
    private void someMethod(){
        throw new RuntimeException();
    }
}
