package thread1.unsafedemo;

public class Unsafe  {


    private static  int get1000 =0 ;

    public static void main(String[] args) throws InterruptedException {
        onetime();

    }

    private static void onetime() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        increase();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }).start();
        }

        Thread.sleep(4000);
        System.out.println(get1000);
    }

    private static synchronized  void increase() {
        get1000++;
    }
}
