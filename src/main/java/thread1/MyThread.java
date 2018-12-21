package thread1;

public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Thread myThread = new MyThread();
        myThread.setName("myname");
        myThread.start();
    }
}
