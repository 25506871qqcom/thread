package thread1;

public class WaitNotify implements  Runnable{

    private static Object obj = new Object();
    private static Object waitobj = new Object();
    @Override
    public void run() {
        synchronized (waitobj){
            System.out.println(Thread.currentThread().getName()+"  get lock ");
            try {
                waitobj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"  release lock ");

    }

    public static void main(String[] args) throws InterruptedException {

//        Thread thread = new Thread(new WaitNotify(),"first thread");
//
//        thread.start();
//        Thread.sleep(1000);
//        synchronized (waitobj){
//            waitobj.notify();
//        }
        Thread thread = new Thread(new WaitNotify(),"first thread");

        thread.start();

        Thread thread2 = new Thread(new WaitNotify(),"second thread");

        thread2.start();

        Thread.sleep(3000);
        synchronized (waitobj){
            waitobj.notify();
            waitobj.notify();
//            waitobj.notifyAll();
        }
//        Thread.sleep(3000);



    }
}
