/**
 * 111
 */

package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 饿汉
 */
@ThreadSafe
public class SingletonExample6 {

    //私有
    private SingletonExample6(){

    }
    //单利
    private static SingletonExample6 instance=null;

    static {
        instance=new SingletonExample6();
    }


    public static SingletonExample6 getInstance(){
            return instance;
    }
    public static void main(String[] args) {
        System.out.println( SingletonExample6.getInstance());
        System.out.println( SingletonExample6.getInstance());
    }
}
