package thread1.interrupt;

import java.util.Date;

public class safe_stop_interrupt_runnable_volatile implements Runnable {

    private static volatile boolean flag = true;
//    private static  boolean flag = true;

    @Override
    public void run() {
       while(flag){
           System.out.println(new Date()+"  "+Thread.currentThread().isInterrupted());
       }
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(new safe_stop_interrupt_runnable_volatile()).start();

        Thread.sleep(1000);
//        unsafe_stop.stop();
//        unsafe_stop.interrupt();
        flag = false ;
    }
}
