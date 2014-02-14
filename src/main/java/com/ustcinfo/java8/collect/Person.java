package com.ustcinfo.java8.collect;

/**
 * Created by melin on 14-2-1.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
