package Throws;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class ThreadLocalRandomAndTimeUnit1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(TimeUnit.DAYS.toMillis(14));
//        System.out.println(Math.random());
//        System.out.println(ThreadLocalRandom.current().nextInt());

    }
}
