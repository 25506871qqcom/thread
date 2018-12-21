package thread1.priority;

public class daemonThread implements Runnable{
    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new daemonThread()) ;
        thread.setName("1");
        thread.setDaemon(true);
        thread.start();


        Thread.sleep(2000);



    }
}
