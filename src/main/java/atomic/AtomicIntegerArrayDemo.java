package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr) ;

        System.out.println(atomicIntegerArray.addAndGet(1,4));
        System.out.println(atomicIntegerArray.addAndGet(1,14));

    }
}
