package lock;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Unsafe {

    private static  int num = 0 ;
    private static ReentrantLock  lock = new ReentrantLock();
//    private static MyLock  lock = new MyLock();

    private static  CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        try {
                            add();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    countDownLatch.countDown();
                }
            }).start();

        }

        while(countDownLatch.getCount()>0){
            System.out.println(countDownLatch.getCount()+"  "+new Date());
            Thread.sleep(500);
        }

        countDownLatch.await();

//        Thread.sleep(20000);

        System.out.println(num+"  "+new Date());

    }

    private static synchronized  void add_sync() throws InterruptedException {
        Thread.sleep(10);
        num++;
    }

    private static   void add() throws InterruptedException {

        lock.lock();

        num++;
        lock.unlock();
    }

}
