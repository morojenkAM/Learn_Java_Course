package Throws;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static Throws.Resource.i;

public class ForkJoinFramework1 {
    static long numOfOperetions = 10_000_000_000L;
static int numOfThread = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        System.out.println(numOfThread);
        ForkJoinPool pool = new ForkJoinPool();//permite ca operatia sa fie in mai multe parti
        System.out.println(pool.invoke(new MyFork(0, numOfOperetions)));



//        long j = 0;
//        for (long i = 0; i < numOfOperetions; i++) {
//            j += i;
//        }
        //System.out.println(j);
        System.out.println(new Date());
    }
    static class MyFork extends RecursiveTask<Long> {
        long from, to; //de la pana la

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        protected Long compute() {
            if ((to - from) <= numOfOperetions / numOfThread) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);//cream clasa MyFolk doar pe 2 parti
                firstHalf.fork();

                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondVlue = secondHalf.compute();
                return firstHalf.join() + secondVlue;
            }
        }
    }
}

