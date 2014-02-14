package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

/**
 * Created by melin on 14-2-14.
 */
public class PrintResult implements CompletableFuture.Action<String> {
    @Override
    public void accept(String result) {
        System.out.println(Thread.currentThread().getName() + " 运行结果：" + result);
    }
}
