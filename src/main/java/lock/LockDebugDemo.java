package lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDebugDemo {

    private int num = 0 ;

    private ReentrantLock reentrantLock = new ReentrantLock() ;

    public void add(){
        reentrantLock.lock();

        try{
            num++;
            System.out.println(num);
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {

        LockDebugDemo debugDemo = new LockDebugDemo() ;
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    debugDemo.add();
                }
            }).start();
        }
    }
}
