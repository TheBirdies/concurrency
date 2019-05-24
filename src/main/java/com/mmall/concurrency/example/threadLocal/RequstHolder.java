/**
 * 111
 */

package com.mmall.concurrency.example.threadLocal;

public class RequstHolder {
    private final static ThreadLocal local=new ThreadLocal();
    public static void add(Long id){
        local.set(id);
    }

     public static  Long getId(){
     return  (Long)local.get();
        }
    public static  void remove(){
        local.remove();
    }


}
