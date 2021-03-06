/**
 * 111
 */

package com.mmall.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class CollectionHashMapperExample1 {

    public  static int clientTotal=5000;
    static  int threadTotal=200;

    private static Map<Integer,Integer> map= Collections.synchronizedMap(new HashMap<>());//HashMap 线程不安全
//    private static Map<Integer,Integer> map=new Hashtable<>();//线程安全

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            final  int count=i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("{}",map.size());
    }
    private static void  update(int i){
        map.put(i,i);
    }
}
