/**
 * 111
 */

package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annoations.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NoThreadSafe
public class DateFormatExample1 {

    //SimpleDateFormat  因为是成员变量 它不是个线程安全类
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");

    public  static int clientTotal=5000;
    static  int threadTotal=200;
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
    }
    private static void  update(){
        try {
            simpleDateFormat.parse("20190523");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
