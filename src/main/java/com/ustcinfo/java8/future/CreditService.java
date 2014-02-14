package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

import java.util.concurrent.TimeUnit;

/**
 * Created by melin on 14-2-14.
 */
public class CreditService implements CompletableFuture.Fun<String, String> {

    @Override
    public String apply(String msg) {
        System.out.println(Thread.currentThread().getName() + " 获取用户信用信息");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg + " : 100";
    }
}
