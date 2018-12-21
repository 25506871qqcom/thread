package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private int i = 0 ;

    private int j = 0 ;

    private ReadWriteLock reentrantReadWriteLockDemo = new ReentrantReadWriteLock();

    Lock readLockDemo = reentrantReadWriteLockDemo.readLock();
    Lock writeLockDemo = reentrantReadWriteLockDemo.writeLock();

    public void out (){
        readLockDemo.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" i,j=="+i+","+j);
        }finally {
            readLockDemo.unlock();
        }

    }

    public void add(){
        writeLockDemo.lock();
        try{

            i++;
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            j++;
        }finally {
            writeLockDemo.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

//        for (int i = 0; i < 4; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    readWriteLockDemo.add();
//                    readWriteLockDemo.out();
//                }
//            }).start();
//        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                readWriteLockDemo.add();
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.out();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.out();
            }
        }).start();


    }
}
