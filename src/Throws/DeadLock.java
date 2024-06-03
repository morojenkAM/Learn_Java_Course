package Throws;

public class DeadLock {
    public static void main(String[] args)  {
        //daca avem mai multe fire  si ele pot sa porneasc cateva resrse,dar aceste resurse are link la unca catre alta
        //si ele se intercaleaza
        //deadlock - problema ca 2 fire care se interacaleaza
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        //stabilimi circularitatea
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.resourceA = resourceA;
        myThread2.resourceB = resourceB;
        myThread1.start();
        myThread2.start();
    }
}
class MyThread1 extends Thread {
    ResourceA resourceA;

    public void run(){
        System.out.println(resourceA.getI());
    }
}
class MyThread2 extends Thread {
    ResourceB resourceB;
    public void run(){
        System.out.println(resourceB.getI());
    }
}

class ResourceA{
    ResourceB resourceB;
    public synchronized int getI(){
        return resourceB.returnI();
    }
    public synchronized  int returnI(){
        return 1;
    }
}

class ResourceB{
    ResourceA resourceA;
    public synchronized int getI(){
        return resourceA.returnI();
    }
    public synchronized  int returnI(){
        return 5;
    }

}