/**
 * 111
 */

package com.mmall.concurrency.example.singleton;

public class SingletonExample7 {
    private SingletonExample7(){

    }
    public  static SingletonExample7 getInstance(){
        return  Singleton.INSTANCE.getSingleton();
    }
    private enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;
        Singleton(){//JVM 保证只调用一次
            singleton=new SingletonExample7();
        }
        public  SingletonExample7 getSingleton(){
            return singleton;
        }
    }

}
