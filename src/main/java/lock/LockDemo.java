package lock;

public class LockDemo {
    private static Object HALT_A = new Object();
    private static Object HALT_B = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (HALT_A) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (HALT_B) {
                    System.out.println("1");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (HALT_B) {

                synchronized (HALT_A) {
                    System.out.println("2");
                }
            }
        }).start();



//        jstack 35134

    }
}
