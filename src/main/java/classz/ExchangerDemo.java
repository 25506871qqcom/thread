package classz;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();

        String str1 = "xd" ;
        String str2 ="xm" ;

        new Thread(()->{

            System.out.println(Thread.currentThread().getName()+"  build "+str1);

            try {
                String exchange = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName()+"  get "+exchange);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"name1").start();

        new Thread(()->{

            System.out.println(Thread.currentThread().getName()+"  build "+str2);

            try {
                String exchange = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName()+"  get "+exchange);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"name2").start();

    }
}
