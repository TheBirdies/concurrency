/**
 * 111
 */

package com.mmall.concurrency.example.commonUnsafe;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j

public class DateFormatExample3 {


    public  static int clientTotal=5000;
    static  int threadTotal=200;
    private static DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern("yyyyMMdd");
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
        Date da= DateTime.parse("20190523",dateTimeFormatter).toDate();

    }
}
