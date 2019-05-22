/**
 * 111
 */

package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    //代码块
    public  void  test1(int j){
        synchronized(this){
            for(int i=0;i<10;i++){
                log.info("test1 {} -{}",j,i);
            }
        }
    }

    //作用范围整个方法
    synchronized void test2(int j){
        for(int i=0;i<10;i++){
            log.info("test2 {}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 s1=new SynchronizedExample1();
        SynchronizedExample1 s2=new SynchronizedExample1();
        ExecutorService executor= Executors.newCachedThreadPool();
        executor.execute(() ->{
            s1.test1(1);
        });
        executor.execute(() ->{
            s2.test1(2);
        });

    }

}
