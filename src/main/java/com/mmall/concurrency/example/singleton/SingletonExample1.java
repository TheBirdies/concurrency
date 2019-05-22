/**
 * 111
 */

package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NoThreadSafe;

//单线程没问题，线程不安全
//懒汉
@NoThreadSafe
public class SingletonExample1 {

    //私有
    private SingletonExample1(){

    }
    //单利
    private static SingletonExample1 instance=null;
    public static SingletonExample1 getInstance(){
            if(instance==null){
                instance=new SingletonExample1();
            }
            return instance;
    }

    public static void main(String[] args) {

    }
}
