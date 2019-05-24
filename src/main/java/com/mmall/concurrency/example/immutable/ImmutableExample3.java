/**
 * 111
 */

package com.mmall.concurrency.example.immutable;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    private final static List<Integer> list=ImmutableList.of(1,2,3);
    private final static ImmutableSet set=ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map=ImmutableMap.of(1,2,3,4,5,6);

    private final static ImmutableMap<Integer,Integer> map2=ImmutableMap.<Integer,Integer>builder()
            .put(1,2).put(3,4).put(5,6).build();

    public static void main(String[] args) {
//        list.add(1);
//        set.add(4);
      log.info("{}",  map.get(1));
    }

}
