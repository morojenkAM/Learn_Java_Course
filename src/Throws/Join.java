package Throws;

public class Join {
    public static void main(String[] args) throws Exception {
        MyTread myTread = new MyTread();
        myTread.start();
        myTread.join();//eu doresc mai intai sa astept pana se termina firul,dupa o sa apara sout
        System.out.println("thread main");
    }
}
class MyTread7 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
