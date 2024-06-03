package Throws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExcecuterService {
    //ScheduledExecutorService este o interfață din Java
    // care extinde ExecutorService și este utilizată
    // pentru a planifica (schedule) sarcini de executare
    // cu întârzieri sau în mod repetat. Aceasta oferă
    // funcționalități avansate pentru gestionarea
    // execuției sarcinilor la momente specificate în timp,
    // fiind extrem de utilă în aplicațiile care necesită
    // execuția periodică sau întârziată a unor operațiuni.
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyThread(), 3, TimeUnit.SECONDS);
    scheduledExecutorService.shutdown();
    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println(1);
        }
    }
}
