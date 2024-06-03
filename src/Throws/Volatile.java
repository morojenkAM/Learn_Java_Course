package Throws;

public class Volatile {
   volatile static int i = 0;//volatile ca ambele metode sa se porneasca dar nnu numai una
    //ii spunem la compilator sa scrie tot ce are,sa scriem in memorie

    public static void main(String[] args) {
        new MyThreadWrite().start();
         new MyThreadRead().start();
    }
    static class MyThreadWrite extends Thread {
        public void run() {
            while (i < 5){
                System.out.println("increment i to " + (++i));
           try {
               Thread.sleep(500);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
            }
        }
    }

    static class MyThreadRead extends Thread {
        public void run() {
            int localVar = i;
            while (localVar < 5){
                if (localVar != i){
                    System.out.println("new value of i is" + i);
                }
            }
        }
    }
}
