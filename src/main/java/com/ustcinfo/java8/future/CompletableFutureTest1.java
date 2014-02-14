package com.ustcinfo.java8.future;

import jsr166e.CompletableFuture;

import java.io.IOException;

/**
 * Created by melin on 14-2-14.
 */
public class CompletableFutureTest1 {

    public static void main(String[] args) {
        CompletableFuture<String> user = CompletableFuture.supplyAsync(new UserService());

        CompletableFuture<String> credit1 = user.thenApplyAsync(new CreditService());
        CompletableFuture<String> credit2 = user.thenApplyAsync(new CreditService());

        credit1.thenCombineAsync(credit2, new CombineCreditService()).thenAccept(new PrintResult());

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
