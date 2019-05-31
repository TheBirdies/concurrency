/**
 * 111
 */

package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class CyclicBarrierExample1 {

    private static CyclicBarrier barrier=new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            final  int threadNum=i;
            Thread.sleep(1000);
                executorService.execute(() ->{
                    try {
                        rece(threadNum);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        }
    }
    private  static  void rece(int threadNum)throws Exception{
            Thread.sleep(1000);
            log.info("{} is ready",threadNum);
            barrier.await();
            log.info("{} continue");
    }
}
