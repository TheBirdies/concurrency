/**
 * 111
 */

package com.mmall.concurrency.example.immutable;


import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

//不可变
@Slf4j
@NoThreadSafe
/**
 * final 修饰类 不可被继承
 * 修饰基本变量 不可修改
 * 修饰引用类型  会有线程安全问题
 *
 * 不想值变化 可以用final 修饰
 */
public class ImmutableExample1 {
    private final static Integer a=1;
    private final static String b="2";
    private final static Map<Integer,Integer> c= Maps.newHashMap();
    static {
        c.put(1,2);
        c.put(3,4);
        c.put(5,6);
    }
    //final 修饰 方法参数的基础类型 也会不可修改
    private  void test(final  int a){
//        a=4;
    }
    public static void main(String[] args) {
//        a=2;
//        b="2";
//        c=Maps.newHashMap();
        c.put(1,3);
        log.info("{}",c.get(1));
    }
}
