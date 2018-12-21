package join;

import java.util.Date;

public class JoinAB {

    public static void main(String[] args) {
        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" begin "+new Date());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" end"+new Date());

            }
        },"thread 1");

        Thread thread2= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" begin "+new Date());
                 thread1.start();

                try {
                    thread1.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" end "+new Date());

            }
        },"thread 2");

        thread2.start();

    }
}
