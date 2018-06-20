package pers.vin.base.optimization;

/**
 * Created by vin on 2018/6/20.
 *  optimization
 */
public class shiftSample {

    public static void main(String[] args) {
        int a, b;
        long startTime = System.nanoTime();
        System.out.println(startTime);
        for (int val = 0; val < 100000; val += 5) {
            a = val * 8;
            b = val / 2;
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        for (int val = 0; val < 100000; val += 5) {
            a = val << 3;
            b = val >> 1;
        }
        System.out.println(System.nanoTime() - endTime);


    }
}
