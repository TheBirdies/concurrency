/**
 * 111
 */

package com.mmall.concurrency.example.lock;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@ThreadSafe
public class LockExample3 {

    //读取很多 写入很少  会导致写一致等待
    private final Map<String,Data> map=new TreeMap<>();
    private final static ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    final static Lock readLock=lock.readLock();
    final static Lock writeLock=lock.writeLock();
    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }

    }
    public Set<String> getAllKey(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }
    public Data put(String key,Data val){
        writeLock.lock();
        try {
            return map.put(key,val);
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
    }
    class Data{
        public Data() {

        }
    }
}
