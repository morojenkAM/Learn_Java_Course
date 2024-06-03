package Throws;

public class WaitingBlockingSleeping {
    public static void main(String[] args)  {
        MyTread myTread = new MyTread();
        myTread.start();
        myTread.interrupt();
        try {

            Thread.sleep(1000);//adorme pe o secunda si nu se executa si in timpul asta se executa clasa de dedesupt
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread main");
    }
}

class MyTread1 extends Thread {
    public void run() {
        System.out.println("thread 0 ");
    }
}