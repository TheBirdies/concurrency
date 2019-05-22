/**
 * 111
 */

package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicCount5 {
   static AtomicIntegerFieldUpdater<AtomicCount5> updater=AtomicIntegerFieldUpdater.newUpdater(AtomicCount5.class,"count");

   @Getter
   volatile int count =100;

   static AtomicCount5 ex5=new AtomicCount5();

    public static void main(String[] args) {
         boolean b=updater.compareAndSet(ex5,100,200);
        if(b){
            System.out.println(1);
        }
        boolean b2=updater.compareAndSet(ex5,100,200);
        if(b2){
            System.out.println(2);
        }
    }

}
