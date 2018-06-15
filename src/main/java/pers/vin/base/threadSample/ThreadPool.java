package pers.vin.base.threadSample;


import java.util.concurrent.*;

/**
 * Created by vin on 2018/6/14.
 */
public class ThreadPool {


    public static void main(String[] args) {


        /***
         * ========newCachedThreadPoll========
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newCachedThreadPool----" + System.currentTimeMillis());
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newCachedThreadPool----" + System.currentTimeMillis());
            }
        });

        executorService.shutdown();

        /***
         * ========newSingleThreadExecutor========
         */


        executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newSingleThreadExecutor----" + System.currentTimeMillis());
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newSingleThreadExecutor----" + System.currentTimeMillis());
            }
        });

        executorService.shutdown();

        /***
         * ========newFixedThreadPool========
         */


        executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newFixedThreadPool----" + System.currentTimeMillis());
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newFixedThreadPool----" + System.currentTimeMillis());
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "--newFixedThreadPool----" + System.currentTimeMillis());
            }
        });

        executorService.shutdown();


        /***
         * ========newScheduledThreadPool========
         */

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "====1=====" + System.currentTimeMillis());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "====1=====" + System.currentTimeMillis());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "====1=====" + System.currentTimeMillis());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
        //scheduledExecutorService.shutdown();
    }


}

