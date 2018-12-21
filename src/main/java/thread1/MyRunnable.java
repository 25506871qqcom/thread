package thread1;

public class MyRunnable implements  Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("runnable name");
        thread.start();
//        thread.run();

    }
}
