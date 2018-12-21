package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//重入锁
public class MyLockRetry implements Lock {

    private static  boolean isHoldLock = false ;

    private Thread lockThread = null ;
    private int reentryCount=0;

    @Override
    public synchronized  void lock() {
      if(isHoldLock&&Thread.currentThread()!=lockThread){
          try {
              wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
        lockThread = Thread.currentThread();
      isHoldLock=true;
        reentryCount++;
    }

    @Override
    public synchronized void unlock() {
        if(lockThread==Thread.currentThread()) {
            notify();
            reentryCount--;
            if(0==reentryCount) {
                notify();
                isHoldLock = false;
            }
        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
