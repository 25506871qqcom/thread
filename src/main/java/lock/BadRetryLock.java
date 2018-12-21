package lock;

public class BadRetryLock {


    private static MyLockRetry myLock = new MyLockRetry();
    public static void main(String[] args) {


       methodA();
       

    }

    private static void methodA() {
        myLock.lock();
        System.out.println("enter a");
        methodB();
        myLock.unlock();
        System.out.println(" out a ");
    }

    private static void methodB() {
        myLock.lock();
        System.out.println("enter b");
        myLock.unlock();
        System.out.println(" out b ");
    }

}
