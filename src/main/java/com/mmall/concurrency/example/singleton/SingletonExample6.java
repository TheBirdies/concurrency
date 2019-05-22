/**
 * 111
 */

package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NoThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 饿汉
 */
@ThreadSafe
public class SingletonExample2 {

    //私有
    private SingletonExample2(){

    }
    //单利
    private static SingletonExample2 instance=new SingletonExample2();
    public static SingletonExample2 getInstance(){
            return instance;
    }
    public static void main(String[] args) {

    }
}
