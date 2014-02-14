package com.ustcinfo.java8.defaultInterface;

/**
 * Created by melin on 14-2-1.
 */
public interface HelloInterface {
    public default void hello() {
        System.out.println("default hello");
    }
}
