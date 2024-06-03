package Throws;

public class SinhronizareaStatica {
        public static void main(String[] args) throws Exception {
            Resource.i = 5;
            Throws.MyThread9 myThread1 = new Throws.MyThread9();
            myThread1.setName("one");
            Throws.MyThread9 myThread2 = new Throws.MyThread9();
            myThread1.start(); // Pornim primul fir
            myThread2.start(); // Pornim al doilea fir
            myThread1.join(); // Așteptăm terminarea primului fir
            myThread2.join(); // Așteptăm terminarea celui de-al doilea fir
            System.out.println(Resource.i);
        }
    }

    class MyThread9 extends Thread {
        Throws.Resource resource;

        public void run() {
            Resource1.changeStaticI();
            new Resource().changeI();
        }
    }

    class Resource1 {
       static int i;

        public static void changeStaticI() {
            synchronized (Resource.class){
                // Facem metoda sincronizată pentru a evita problemele de concurență si copiere
                int i = Resource.i;
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
            }
            i++;
            Resource.i = i;

        }
        public void changeI() {
            synchronized (this){
                // Facem metoda sincronizată pentru a evita problemele de concurență si copiere
                int i = Resource.i;
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
            }
            i++;
            Resource.i = i;

        }

//      diferenta dintre sinhronizarearea simpla si sinhronizarea statica
        //staic facem la nivelul clasei
        //dar simplu este nu intre toate pana nu le mentionezi cu this
        //ele pot sa functioneze ambele impreuna
        //dar nu trebuie de le compbinat pentru ca nu dau ceva concret

}
