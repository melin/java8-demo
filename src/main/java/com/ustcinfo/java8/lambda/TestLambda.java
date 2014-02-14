package com.ustcinfo.java8.lambda;

import java.util.concurrent.TimeUnit;

/**
 * Created by melin on 14-2-1.
 */
public class TestLambda {
    public static void runThreadUseLambda() {
        new Thread(() -> System.out.println("lambda实现的线程")).start();
    }

    public static void runThreadUseInnerClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现线程");
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        runThreadUseLambda();
        runThreadUseInnerClass();

        TimeUnit.SECONDS.sleep(1);
    }
}
