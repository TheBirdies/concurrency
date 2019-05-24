/**
 * 111
 */

package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annoations.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class StringExample1 {
    public  static int clientTotal=5000;
    static  int threadTotal=200;
    static int count =0;
//    static  StringBuilder str=new StringBuilder();// 不安全 //一般方法里定义的局部变量已经保证了一个线程在执行 优先选择
    static  StringBuffer str=new StringBuffer();//线程安全 单性能不好

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    update();
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
        log.info("count:{}",str.length());
    }
    private static void  update(){
//        count++;
        str.append("1");
    }

}
