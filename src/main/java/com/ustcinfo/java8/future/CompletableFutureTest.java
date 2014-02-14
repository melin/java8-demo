package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

import java.io.IOException;

/**
 * Created by melin on 14-2-14.
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(new UserService())
                .thenApply(new CreditService())
                .thenAccept(new PrintResult());

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
