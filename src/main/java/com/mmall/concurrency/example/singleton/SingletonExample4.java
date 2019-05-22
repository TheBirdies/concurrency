/**
 * 111
 */

package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NoThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//单线程没问题，线程不安全
//懒汉模式
@NoThreadSafe
public class SingletonExample4 {

    //私有
    private SingletonExample4(){
        System.out.println( Thread.currentThread().getName());
    }
    //1.memory=allocate() 分配对象内存空间
    //2.ctorInstance() 初始化对象
    //3.instance=memory 设置instance指向刚分配的内存


    //JVM 和cpu优化，发生指令重排
    //1.memory=allocate() 分配对象内存空间
    //3.instance=memory 设置instance指向刚分配的内存
    //2.ctorInstance() 初始化对象




    //单利
    private static SingletonExample4 instance=null;
    //synchronized  双重检测机制
    public static  SingletonExample4 getInstance(){
            if(instance==null){                     //B
                synchronized(SingletonExample4.class){ //同步
                   if(instance==null){
                       instance=new SingletonExample4();  //A
                   }
                }
            }
            return instance;
    }
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i=0;i<100;i++){
            executorService.execute(() ->{
                SingletonExample4 singletonExample4= SingletonExample4.getInstance();
                System.out.println(singletonExample4);
            });
        }
        executorService.shutdown();

    }
}
