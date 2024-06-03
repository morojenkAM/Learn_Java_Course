package Throws;

public class Synchrone {
    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.i = 5;
        MyThread8 myThread1 = new MyThread8();
        myThread1.setName("one");
        MyThread8 myThread2 = new MyThread8();
        myThread1.setResource(resource); // Setăm resursa pentru primul fir
        myThread2.setResource(resource); // Setăm resursa pentru al doilea fir
        myThread1.start(); // Pornim primul fir
        myThread2.start(); // Pornim al doilea fir
        myThread1.join(); // Așteptăm terminarea primului fir
        myThread2.join(); // Așteptăm terminarea celui de-al doilea fir
        System.out.println(resource.i);
    }
}

class MyThread8 extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        resource.changeI();
    }
}

class Resource {
    static int i;

    public synchronized void changeI() { // Facem metoda sincronizată pentru a evita problemele de concurență si copiere
        int i = this.i;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }

        i++;
        this.i = i;



    }
}
