package classz;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TotalCountDown {

    private static int v = 0 ;
    private static int j = 0 ;
    private static int k = 0 ;

    private static CountDownLatch countDownLatch = new CountDownLatch(3) ;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        try {
                            Thread.sleep(new Random().nextInt(4000) + 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " done");
                    }finally {
                        countDownLatch.countDown();
                    }

                }
            }).start();
        }





        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("al done ");
            }
        }).start();

        System.out.println("main");

    }
}
