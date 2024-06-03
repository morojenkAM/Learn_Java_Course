package Throws;

public class CreareaFirilorCandSeSchimbaOrdineaObservari {
    public static void main(String[] args) {
        new MyTread().start();
        new MyTread().start();
        new MyTread().start();
        new MyTread().start();
        new MyTread().start();

    }
    static class MyTread extends Thread {
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println("Thread name is -" + Thread.currentThread().getName() + "i = " +i);
            }
        }
    }
}
