package thread1;

public class SuspendDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "  before suspend");
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName()+ "  after resume");
    }


    public static void main(String[] args) {
        Thread t = new Thread(new SuspendDemo());
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.resume();
    }
}
