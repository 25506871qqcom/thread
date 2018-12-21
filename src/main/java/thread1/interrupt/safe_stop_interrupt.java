package thread1.interrupt;

import java.util.Date;

public class safe_stop_interrupt extends Thread {


    @Override
    public void run() {
       while(!Thread.currentThread().isInterrupted()){
           System.out.println(new Date()+"  "+Thread.currentThread().isInterrupted());
       }
        System.out.println(new Date()+" done "+Thread.currentThread().isInterrupted());
    }


    public static void main(String[] args) throws InterruptedException {
        safe_stop_interrupt unsafe_stop = new safe_stop_interrupt();
        unsafe_stop.start();

        Thread.sleep(1000);
//        unsafe_stop.stop();
        unsafe_stop.interrupt();
    }
}
