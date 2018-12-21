package thread1.interrupt;

public class Unsafe_stop extends Thread {

    private static int i = 0;
    private static int j = 0;

    @Override
    public void run() {
        i++;
        try {
            sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    private static void print() {
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) throws InterruptedException {
        Unsafe_stop unsafe_stop = new Unsafe_stop();
        unsafe_stop.start();

        Thread.sleep(1000);
//        unsafe_stop.stop();
        unsafe_stop.interrupt();
        print();
    }
}
