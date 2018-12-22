package executors;

import java.util.Random;

public class RandomTime {

    public static void random5seconds(){
        int rand = new Random().nextInt(5000)+1000;
        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void random10seconds(){
        int rand = new Random().nextInt(10000)+1000;
        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void random2seconds(){
        int rand = new Random().nextInt(1000)+1000;
        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
