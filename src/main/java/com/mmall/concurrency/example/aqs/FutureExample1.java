/**
 * 111
 */

package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample1 {
    static class MyCallble implements Callable {
        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "555";
        }
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Future future=
        int i=20;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future= executorService.submit(new MyCallble());
        log.info("do something in main");
        Thread.sleep(1000);
        log.info("todo ");
        String a=future.get();
        log.info(a);
        executorService.shutdown();
    }

}
