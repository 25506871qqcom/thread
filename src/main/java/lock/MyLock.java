package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private static volatile boolean isHoldLock = false ;
    @Override
    public synchronized  void lock() {
      if(isHoldLock){
          try {
              wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      isHoldLock=true;
    }

    @Override
    public synchronized void unlock() {
        notify();
        isHoldLock=false;
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
