package executors;

import com.sun.tools.javac.main.Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

public class ThreadpoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int nworks = 20;

        int csize = 10 ;
        int msize = 24 ;

        CopyOnWriteArrayList<String> times = new CopyOnWriteArrayList<>() ;
        //任务数 x  大于 最大与 队列的，就不会干了？不会做完？ 50>20 + 20 = 10 个不做
        int x = 50 ; //40-23 = 17
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(nworks);
        ThreadPoolExecutor threadPoolExecutor
                = new ThreadPoolExecutor(csize,msize,3, TimeUnit.SECONDS,blockingQueue
                ,new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        threadPoolExecutor.prestartAllCoreThreads();
        Future<String> submit = null ;
        for (int i = 0; i < x; i++) {
         threadPoolExecutor.submit(()-> {
                  RandomTime.random5seconds();
          });
            times.add(UUID.randomUUID().toString());
            System.out.println(threadPoolExecutor.getActiveCount());
            System.out.println("done:"+times.size());
        }


        // 1  ok

    }
}
