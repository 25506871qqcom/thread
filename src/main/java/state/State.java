package state;

import java.io.IOException;

public class State {
    public static void main(String[] args) throws InterruptedException {


        //Runnable
//        Thread thread =  new Thread(()->{
//            try {
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
        Object obj = new Object();
        //block
//        Object obj = new Object();
//
//                Thread thread =  new Thread(()->{
//
//                    synchronized (obj){
//                        try {
//                            Thread.sleep(Long.MAX_VALUE);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//        });
//        thread.start();
//
//        Thread.sleep(2000);
//
//        Thread thread2 =  new Thread(()->{
//            synchronized (obj){
//                //再锁之
//            }
//        });
//        thread2.start();


        //waiter
                Thread thread2 =  new Thread(()->{
            synchronized (obj){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

    }
}
