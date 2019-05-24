/**
 * 111
 */

package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample2 {
    private static  int threadCount=200;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(3);
        for(int i=0;i<threadCount;i++){
                final int threadNum=i;
                executorService.execute(()->{
                    try {
                        if(semaphore.tryAcquire()){
//                        if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){
                            test(threadNum);
                            semaphore.release();//释放许可
                        }
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
