/**
 * 111
 */

package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExample1 {
    private static  int threadCount=200;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(3);
        for(int i=0;i<threadCount;i++){
                final int threadNum=i;
                executorService.execute(()->{
                    try {
                        semaphore.acquire(); //获取许可
                        test(threadNum);
                        semaphore.release();//释放许可
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        }
        log.info("finish");
        executorService.shutdown();

    }
    static  void test(int threadNum ) throws InterruptedException {
        Thread.sleep(1000);
        log.info("{}",threadNum);
    }
}
