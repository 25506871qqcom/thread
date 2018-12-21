package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt implements Runnable {


    private static  int v = 0 ;
//    private static AtomicInteger v = new AtomicInteger(0) ;
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            add();
        }

    }

//    synchronized
    private synchronized  void add() {
//        v.incrementAndGet();
        v++;


    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new AtomicInt()).start();
        }



        System.out.println(v);
    }
}
