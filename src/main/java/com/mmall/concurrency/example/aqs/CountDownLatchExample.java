/**
 * 111
 */

package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchExample {
    private static  int threadCount=200;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch=new CountDownLatch(threadCount);
        for(int i=0;i<threadCount;i++){
                final int threadNum=i;
                executorService.execute(()->{

                    try {
                        test(threadNum);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }

                });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("finish");
        executorService.shutdown();

    }
    static  void test(int threadNum ) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}",threadNum);
        Thread.sleep(100);
    }
}
