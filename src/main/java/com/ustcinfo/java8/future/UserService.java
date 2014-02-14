package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

import java.util.concurrent.TimeUnit;

/**
 * Created by melin on 14-2-14.
 */
public class UserService implements CompletableFuture.Generator<String> {
    @Override
    public String get() {
        System.out.println(Thread.currentThread().getName() + " 获取用户信息");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "melin";
    }
}
