package Throws;

import java.util.concurrent.Phaser;

public class Phaser1 {
    //lucru care le impartim in etape si nu putem incepe vreo etapa daca nu terminam alta
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Înregistrăm faza principală
        new Washer(phaser);
        new Washer(phaser);

        for (int i = 0; i < 3; i++) {
            phaser.arriveAndAwaitAdvance(); // Principalul thread așteaptă
        }

        phaser.arriveAndDeregister(); // Principalul thread termină
    }

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            phaser.register(); // Înregistrăm participantul
            start();
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();
            }
            phaser.arriveAndDeregister(); // Deregistrăm participantul la final
        }
    }
}
