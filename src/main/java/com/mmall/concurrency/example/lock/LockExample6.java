/**
 * 111
 */

package com.mmall.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample6 {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();

        new Thread(()->{
            lock.lock();
           try {
               log.info("111");
               condition.await();
           }catch (Exception e){

           }
            log.info("111====11");
            lock.unlock();
        }).start();



        new Thread(()->{
            lock.lock();
            try {
                log.info("22222");
                Thread.sleep(3000);
            }catch (Exception e){

            }
            condition.signalAll();
            log.info("2222====2222");
            lock.unlock();
        }).start();

    }
}
