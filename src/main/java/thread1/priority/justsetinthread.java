package thread1.priority;

import sun.jvm.hotspot.tools.JMap;

public class justsetinthread implements Runnable{
    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new justsetinthread()) ;
        thread.setName("1");

        thread.setPriority(Thread.MIN_PRIORITY);

        Thread thread2 = new Thread(new justsetinthread()) ;
        thread2.setName("2");

        thread2.setPriority(Thread.MAX_PRIORITY);

        thread.start();
        thread2.start();



    }
}
