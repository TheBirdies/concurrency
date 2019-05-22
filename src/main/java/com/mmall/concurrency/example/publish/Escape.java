/**
 * 111
 */

package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annoations.NoRecommend;
import com.mmall.concurrency.annoations.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoThreadSafe
@NoRecommend
public class Escape {
    private  int thisCanbeEsape=0;

    public Escape() {
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
                log.info("{}",Escape.this.thisCanbeEsape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
