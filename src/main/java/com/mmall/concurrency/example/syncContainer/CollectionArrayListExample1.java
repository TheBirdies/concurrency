/**
 * 111
 */

package com.mmall.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 使用 Collections 达成线程安全
 */
@Slf4j
public class CollectionArrayListExample1 {

    public  static int clientTotal=5000;
    static  int threadTotal=200;

    private static List<Integer> list= Collections.synchronizedList(new ArrayList<>());

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
        log.info("{}",list.size());
    }
    private static void  update(int i){
        list.add(i);
    }
}
