package Throws;

import java.util.concurrent.Exchanger;

public class Exchenger1 {
    //sa transmita datle eintre fire
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchenger = new Exchanger<>();
new Mike(exchenger);
new Anket(exchenger);
    }
    static class Mike extends Thread {
        Exchanger<String> exchenger;

        public Mike(Exchanger<String> exchenger) {
            this.exchenger = exchenger;
            start();
        }
        public void run() {
            try {
                exchenger.exchange("I m 20 yers old");
                exchenger.exchange("Hi my name is Mike");
                sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Anket extends Thread {
        Exchanger<String> exchenger;

        public Anket(Exchanger<String> exchenger) {
            this.exchenger = exchenger;
            start();
        }
        public void run() {
            try {
                System.out.println(exchenger.exchange(null));
                System.out.println(exchenger.exchange(null));
               // String info = exchenger.exchange(null);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
