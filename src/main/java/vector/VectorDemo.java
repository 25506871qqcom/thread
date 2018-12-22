package vector;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        List<String> list = Collections.synchronizedList(vector);
        for (int i = 0; i < 100; i++) {
            vector.add("demo" + i);
        }


        //正确迭代
//        for (int i = 0; i < vector.size(); i++) {
//            if(vector.get(i).equalsIgnoreCase("demo3")){
//                vector.remove(i);
//            }
//        }

        //错误迭代 Exception in thread "main" java.util.ConcurrentModificationException
//        for(String ele:vector){
//            if(ele.equalsIgnoreCase("demo3")){
//                vector.remove(ele);
//            }
//        }

        //正确迭代 单线程  iterator.remove();  is core
//        Iterator<String> iterator = vector.iterator();
//        while(iterator.hasNext()){
//            String ele = iterator.next();
//            if(ele.equalsIgnoreCase("demo3")){
//                iterator.remove();
//        }
//        }


        //java.util.NoSuchElementException  in thread
//        Iterator<String> iterator = vector.iterator();
//        for (int i = 0; i < 4; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
////                    while (iterator.hasNext()) {
////                        String ele = iterator.next();
////                        if (ele.equalsIgnoreCase("demo3")) {
////                            iterator.remove();
////                        }
////                    }
//                    synchronized (iterator) {
//                        while (iterator.hasNext()) {
//                            String ele = iterator.next();
//                            if (ele.equalsIgnoreCase("demo3")) {
//                                iterator.remove();
//                            }
//                        }
//                    }
//                }
//            }).start();
//        }

//        Iterator<String> iterator = vector.iterator();
        Iterator<String> iterator = list.iterator();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (iterator.hasNext()) {
                        String ele = iterator.next();
                        if (ele.equalsIgnoreCase("demo3")) {
                            iterator.remove();
                        }
                    }

                }
            }).start();
        }

        System.out.println(vector.size());
    }
}
