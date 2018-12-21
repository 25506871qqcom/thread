package thread1;

public class SuspendAndDead  implements  Runnable{

    private static Object obj = new Object();
    @Override
    public void run() {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"  get lock ");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName()+"  release lock ");

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new SuspendAndDead(),"first thread");

        thread.start();
        Thread.sleep(1000);
        thread.resume();

        Thread deadthread = new Thread(new SuspendAndDead(),"dead thread");

        deadthread.start();
//        deadthread.sleep(1000);
        deadthread.resume();


    }
}
