package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

import java.io.IOException;

/**
 * Created by melin on 14-2-14.
 */
public class CompletableFutureTest2 {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(new CompletableFuture.Generator<String>() {
            @Override
            public String get() {
                System.out.println("抛出异常");
                throw new RuntimeException("exception");
            }
        }).thenAccept(new PrintResult()).exceptionally(new CompletableFuture.Fun<Throwable, Void>() {
            @Override
            public Void apply(Throwable throwable) {
                System.out.println("处理异常");
                return null;
            }
        });

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
