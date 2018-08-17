package pers.vin.base.cas;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vin on 2018/6/26.
 */
public class CasSample {

    // safe

    int initialValue = 2;
    AtomicInteger i2 = new AtomicInteger(initialValue);

    void addAndNumber() {


//        try {
//            java.lang.reflect.Field aField = AtomicInteger.class.getDeclaredField("value");
//            aField.setAccessible(true);
//            aField.set(i2,2);
//            Object rValue = aField.get(i2);
//
//
//            System.out.println("rValue is :" + rValue);
//
//        } catch (Exception ex) {
//            throw new Error(ex);
//        }


        i2.incrementAndGet();
        //i2.compareAndSet(initialValue, 1);

        // System.out.println("i is : " + i);
        //System.out.println(Thread.currentThread().getName() + "-initialValue is : " + initialValue);

        //System.out.println(Thread.currentThread().getName() + "-update value is : " + i2.get());

    }

    // unsafe
    int initialValue2 = 2;

    void addNumber() {

        initialValue2 = initialValue2 + 1;
//        try {
//            Thread.sleep(100L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // System.out.println(Thread.currentThread().getName() + "-unsafe initialValue2 is : " + initialValue2);
    }

    public static void main(String[] args) {

        CasSample casSample = new CasSample();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                casSample.addAndNumber();
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                casSample.addAndNumber();
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                casSample.addAndNumber();
            }
        });
        executorService.shutdown();
        try {
            /**
             * Blocks until all tasks have completed execution after a shutdown
             * request, or the timeout occurs, or the current thread is
             * interrupted, whichever happens first.
             * */
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(casSample.i2.get());


        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        executorService2.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                casSample.addNumber();
            }
        });
        executorService2.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                casSample.addNumber();
            }
        });
        executorService2.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                casSample.addNumber();
            }
        });

        executorService2.shutdown();
        try {
            /**
             * Blocks until all tasks have completed execution after a shutdown
             * request, or the timeout occurs, or the current thread is
             * interrupted, whichever happens first.
             * */
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(casSample.initialValue2);

    }
}

