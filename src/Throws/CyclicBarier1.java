package Throws;

import java.util.concurrent.BrokenBarrierException;
import  java.util.concurrent.CyclicBarrier;
public class CyclicBarier1 {
// ca daca sunt 2 fire el nu se porneste ,dar daca 3,se porneste
    public static void main(String[] args) {
        CyclicBarrier cyclicBarier = new CyclicBarrier(3, new Run());
    new SportsMan(cyclicBarier);
    new SportsMan(cyclicBarier);
    new SportsMan(cyclicBarier);
    }

    static class Run extends Thread {
        public void run() {
            System.out.println("Run is begun");
        }
    }

    static class SportsMan extends Thread {
        CyclicBarrier barrier;

        public SportsMan(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
