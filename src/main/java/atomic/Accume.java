package atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

public class Accume {

    public static void main(String[] args) {

        LongBinaryOperator aa = new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left>right?left:right;
            }
        };
        LongAccumulator longAccumulator = new LongAccumulator(aa,0);

        longAccumulator.accumulate(5L);
        System.out.println(longAccumulator.get());
        longAccumulator.accumulate(7L);
        System.out.println(longAccumulator.get());
        longAccumulator.accumulate(6L);
        System.out.println(longAccumulator.get());
    }
}
