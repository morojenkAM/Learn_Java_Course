package Throws;

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        //pentru ce trebuiesc?
        //ne permite ca sa facem ceva momentatn
        //de exemplu masina deseneaza se da la executie ,nu asteapta sa se termine sa se executa dar ea altu si deseana
        //si nu ar fi ok sa controleze ca daca tu ai desenat\//de aceea este notify care anunta
        ThreadA threadA = new ThreadA();
        threadA.start();
        synchronized (threadA) {
            threadA.wait();
        }
        System.out.println(threadA.total);
    }
    static class ThreadA extends Thread {
        int total;

        public void run() {
            synchronized (this){
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                notify();
            }


        }
    }
}
