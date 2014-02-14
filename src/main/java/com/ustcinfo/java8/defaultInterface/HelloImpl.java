package com.ustcinfo.java8.defaultInterface;

/**
 * Created by melin on 14-2-1.
 */
public class HelloImpl implements HelloInterface {

    @Override
    public void hello() {
        System.out.println("hello melin");
    }

    public static void main(String[] args) {
        HelloInterface hello = new HelloImpl();
        hello.hello();
    }
}
