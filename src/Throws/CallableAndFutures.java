package Throws;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutures {
    //inlocuieste runnable
    //Utilizarea interfețelor Callable și Future permite o
    // gestionare mai eficientă și mai flexibilă a sarcinilor
    // asincrone în Java, oferind control și feedback asupra execuției acestora.
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
    static class MyCallable implements Callable<Integer> {
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 10; i++, sum++) {
                Thread.sleep(300);
            }
            return sum;
        }

    }
}
