/**
 * 111
 */

package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NoThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

//单线程没问题，线程不安全
//懒汉模式
@ThreadSafe
public class SingletonExample3 {

    //私有
    private SingletonExample3(){

    }
    //单利
    private static SingletonExample3 instance=null;
    //synchronized 性能开销  不推荐
    public static synchronized SingletonExample3 getInstance(){
            if(instance==null){
                instance=new SingletonExample3();
            }
            return instance;
    }
    public static void main(String[] args) {

    }
}
