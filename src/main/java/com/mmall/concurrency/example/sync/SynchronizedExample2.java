/**
 * 111
 */

package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {

    //代码块
    public static void  test1(int j){
        synchronized(SynchronizedExample2.class){
            for(int i=0;i<10;i++){
                log.info("test1 {} -{}",j,i);
            }
        }
    }

    //作用范围整个方法
   static synchronized void test2(int j){
        for(int i=0;i<10;i++){
            log.info("test2 {}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 s1=new SynchronizedExample2();
        SynchronizedExample2 s2=new SynchronizedExample2();
        ExecutorService executor= Executors.newCachedThreadPool();
        executor.execute(() ->{
            s1.test1(1);
        });
        executor.execute(() ->{
            s2.test1(2);
        });

    }

}
