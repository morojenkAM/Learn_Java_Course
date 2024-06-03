package Throws;

import java.util.concurrent.Semaphore;

public class Semofors {
    public static void main(String[] args) {
        //firele sa vina sa ceara loc ,daca este se acorda ,daca nu atunci nu
        Semaphore table = new Semaphore(2);

Person person = new Person();
Person person2 = new Person();
Person person3 = new Person();
Person person4 = new Person();
Person person5 = new Person();
Person person6 = new Person();
Person person7 = new Person();

person.table = table;
person2.table = table;
person3.table = table;
person4.table = table;
person5.table = table;
person6.table = table;
person7.table = table;

person.start();
person2.start();
person3.start();
person4.start();
person5.start();
person6.start();
person7.start();

    }
}

class Person extends Thread{
    Semaphore table;

    public void run() {
        System.out.println(this.getName() + "waiting for table");
        try {
            table.acquire();//cerem masa
            System.out.println(this.getName() + " eat at the table");
            this.sleep(1000);
            System.out.println(this.getName() + "relase table");
            table.release();//se realizeaza masa
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}