package thread1.syndemo;

import java.util.Date;

public class syndemo {

    public  synchronized  void out(){

        System.out.println(Thread.currentThread().getName()+" start at "+new Date());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" done at "+new Date());
    }

    public static void main(String[] args) {
        syndemo syndemo1 = new syndemo();
        syndemo syndemo2 = new syndemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syndemo1.out();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syndemo2.out();
            }
        }).start();
    }
}
