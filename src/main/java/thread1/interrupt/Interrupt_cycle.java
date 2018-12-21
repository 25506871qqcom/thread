package thread1.interrupt;

import java.util.Date;

public class Interrupt_cycle implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Interrupt_cycle());
        thread.start();

        Thread.sleep(4000);

        thread.stop();
    }
}
