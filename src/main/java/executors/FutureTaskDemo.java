package executors;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable callable = new CallableDemo();

        FutureTask<String> stringFutureTask = new FutureTask<String>(callable);

        new Thread(stringFutureTask).start();

        FutureTask<String> stringFutureTask2 = new FutureTask<String>(callable);

        new Thread(stringFutureTask2).start();

        new Thread(()->{
            String result = null;
            try {
                result = stringFutureTask.get();
                stringFutureTask2.cancel(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result + " at "+ new Date());
        }).start();

        new Thread(()->{
            String result = null;
            try {
                result = stringFutureTask2.get();
                stringFutureTask.cancel(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result + " at "+ new Date());
        }).start();


    }
}
