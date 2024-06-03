package Throws;

import com.sun.jdi.event.ExceptionEvent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executors1 {
    //avem aplicatie care are fire,multe fire
    //si fiecare fir nu se executa iarasi din nou,dar se pastreaza
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);//pentru a crea un pool (piscină) de thread-uri (fire de execuție) cu un număr fix de thread-uri.
        executorService.submit(new MyRunabble() );
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();

    }

    static class MyRunabble implements Runnable{
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String> {
        public String call() throws Exception {
            return "2";
        }
    }
}
