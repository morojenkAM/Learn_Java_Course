package Throws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinhronizareaColectiilor {

    public static void main(String[] args) throws Exception {
        NameList nameList = new NameList();
        nameList.add("First");

        class MyThread extends Thread{
            public void run(){
                System.out.println(nameList.removeFirst());
            }
        }
        MyThread myThread = new MyThread();
        myThread.setName("one");
        myThread.start();
        new MyThread().start();
    }


    static class NameList {
        //avem nevoie pentru sencron pentru ca sa returanm ceva privat
        private List list =  Collections.synchronizedList(new ArrayList<>());

        public void add(String name) {
            list.add(name);
        }

        public String removeFirst(){
            if(list.size() > 0){
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
                return (String)list.remove(0);
            }
                return null;}
    }
}
