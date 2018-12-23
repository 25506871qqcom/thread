package executors;

import java.util.UUID;
import java.util.concurrent.*;

public class Executorsz {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CopyOnWriteArrayList<String> times = new CopyOnWriteArrayList<>() ;
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            executorService.submit(()-> {
                  RandomTime.random5seconds();
          });
            times.add(UUID.randomUUID().toString());
//            System.out.println(executorService.());
            System.out.println("done:"+times.size());
        }


        // 1  ok

    }
}
