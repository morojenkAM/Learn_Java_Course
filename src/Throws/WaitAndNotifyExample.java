package Throws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WaitAndNotifyExample {

    static List<String> strings = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) {
        new Operator().start();
        new Machine().start();
    }
    static class Operator extends Thread{
        public void run(){
            Scanner sc = new Scanner(System.in);
            while(true){
                synchronized(strings){
                    strings.add(sc.nextLine());
                    strings.notify();

                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Machine extends Thread{
        public void run(){
            while(strings.isEmpty()){
                synchronized(strings){
                    try {
                        strings.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(strings.remove(0));
            }
        }
    }
}
