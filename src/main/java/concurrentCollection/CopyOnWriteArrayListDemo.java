package concurrentCollection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();

        for (int i = 0; i < 100; i++) {
            copyOnWriteArrayList.add("ele" + i);
        }

//        for(String ele:copyOnWriteArrayList){
//            if(ele.equalsIgnoreCase("ele4")){
//                copyOnWriteArrayList.remove(ele);
//            }
//        }


        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for (String ele : copyOnWriteArrayList) {
                        if (ele.equalsIgnoreCase("ele4")) {
                            copyOnWriteArrayList.remove(ele);
                        }
                    }

                }
            }).start();
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
