package pers.vin.base.threadSample;

import java.util.concurrent.*;

/**
 * Created by vin on 2018/6/14.
 */
public class CallableSample {


    public static void main(String[] args) {

        ThreadCount tc = null;

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);


        for (int i = 0; i < 4; i++) {
            tc = new ThreadCount(i + 1);
            completionService.submit(tc);
        }
        // 添加结束，及时shutdown，不然主线程不会结束
        executorService.shutdown();

        int total = 0;
        for (int i = 0; i < 4; i++) {
            try {
                /**
                 * take 一直等待
                 */
                //total+=completionService.take().get();
                /**
                 * pool 1. result 为 null 报错
                 *      2. 设置超时时间 ，过期为 null 报错
                 */
                total += completionService.poll(5000, TimeUnit.MILLISECONDS).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(total);
    }


}

class ThreadCount implements Callable<Integer> {
    private int type;

    ThreadCount(int type) {
        this.type = type;
    }


    public Integer call() throws Exception {
        if (type == 1) {
            System.out.println("C盘统计大小");
            return 1;
        } else if (type == 2) {
            Thread.sleep(5000);
            System.out.println("D盘统计大小");
            return 2;
        } else if (type == 3) {
            Thread.sleep(3000);
            System.out.println("E盘统计大小");
            return 3;
        } else if (type == 4) {
            System.out.println("F盘统计大小");
            return 4;
        }
        return null;
    }

}
