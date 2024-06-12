package Throws;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFrameworkExercises {

    static long numOfOperations = 10_000_000_000L;
    static int numOfThread = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(numOfThread);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(new MyFork(0, numOfOperations)));
        ForkJoinPool forkJoinPool2 = new ForkJoinPool(numOfThread);
        System.out.println(forkJoinPool2);

    }

    static class MyFork extends RecursiveTask<Double> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Double compute() {
            if ((to - from) <= numOfOperations / numOfThread) {
                double sum = 0;
                for (long i = from; i < to; i++) {
                    sum += 1.0 / i; // am corectat aici
                }
                return sum;
            } else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();

                MyFork secondHalf = new MyFork(middle + 1, to);
                Double secondValue = secondHalf.compute(); // am corectat aici
                return firstHalf.join() + secondValue;
            }
        }
    }
}
