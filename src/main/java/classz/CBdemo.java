package classz;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CBdemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

        Thread[] threads = new Thread[2] ;
        for (int i = 0; i < 2; i++) {
            threads[i]= new Thread(new RunnableDemo(cyclicBarrier,threads),"name"+i);
        }

        for (int i = 0; i < 2; i++) {
            threads[i].start();
        }
    }
}

class RunnableDemo implements  Runnable{

    private CyclicBarrier cyclicBarrier ;
    private Thread[] threads ;

    public RunnableDemo(CyclicBarrier cyclicBarrier, Thread[] threads) {
        this.cyclicBarrier = cyclicBarrier;
        this.threads = threads;
    }

    public RunnableDemo(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

//        System.out.println(threads.length);
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" ready at "+ new Date());

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        while(!Thread.currentThread().isInterrupted()) {
            dosth(threads);
        }

    }

    private synchronized void dosth(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) {
            if(Thread.currentThread().getName().equals(threads[i].getName())){
                //do nothing
            }else{
                threads[i].interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+" all run at "+ new Date());

        Thread.currentThread().interrupt();
    }
}
