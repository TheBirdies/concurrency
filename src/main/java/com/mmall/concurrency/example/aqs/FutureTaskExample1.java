/**
 * 111
 */

package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureTaskExample1 {
    static class MyCallble implements Callable {
        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "555";
        }
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask=new FutureTask<String>(new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "dqwdqw";
            }
        });
            new Thread(futureTask).start();
            log.info("执行");
              String str=  futureTask.get();
        System.out.println(str);
    }

}
