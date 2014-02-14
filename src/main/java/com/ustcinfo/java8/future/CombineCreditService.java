package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

/**
 * Created by melin on 14-2-14.
 */
public class CombineCreditService implements CompletableFuture.BiFun<String, String, String> {
    @Override
    public String apply(String o, String o2) {
        System.out.println(Thread.currentThread().getName() + " 合并信用记录");
        return o + "\t" + o2;
    }
}
