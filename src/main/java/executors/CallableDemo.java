package executors;

import java.util.Date;
import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {

        RandomTime.random10seconds();
        String result = Thread.currentThread().getName()+" "+new Date();
        System.out.println(result);
        return result;
    }
}
