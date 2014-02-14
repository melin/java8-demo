package com.ustcinfo.java8.collect;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by melin on 14-2-1.
 */
public class ListTest {

    public static void test0() {
        List<Person> persons = Arrays.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
        for (Person p :  persons) {
            p.setLastName("Doe");
        }
    }

    public static void test1() {
        List<Person> persons = Arrays.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
        persons.forEach(p -> p.setLastName("Doe"));
    }

    public static void test2() {
        List<Person> persons = Arrays.asList(new Person("Joe", 12), new Person("Jim", 34), new Person("John", 23));

        Stream<Person> personsOver18 = persons.stream().filter(p -> p.getAge() > 18);
        personsOver18.forEach(p -> System.out.println(p.getFirstName()));
    }

    public static void test3() {
        List<Person> persons = Arrays.asList(new Person("Joe", 12), new Person("Jim", 34), new Person("John", 23));

        Stream<Adult> stream = persons.stream().filter(p -> p.getAge()>18).map(p -> new Adult(p));

        System.out.println(stream.count());
    }

    public static void test4() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Joe", 12));
        persons.add(new Person("Jim", 34));
        persons.add(new Person("John", 23));

        List<Person> list = persons.stream().filter(p -> p.getAge() > 18).collect(Collectors.toList());
        list.forEach(p -> System.out.println(p.getFirstName()));
    }

    public static void test5() {
        long t0 = System.nanoTime();
        //初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法
        int a[]= IntStream.range(0, 1_000_000).filter(p -> p % 2==0).toArray();
        long t1 = System.nanoTime();

        //和上面功能一样，这里是用并行流来计算
        int b[]=IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2==0).toArray();
        long t2 = System.nanoTime();

        //我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
    }

    public static void test6() {
        List<String> list = new ArrayList<>();
        list.add("A");// 由于addAll期望获得Collection<? extends String>类型的参数，因此下面的语句无法通过
        list.addAll(new ArrayList<>());
    }

    public static void sortTest() {
        List<Person> persons = Arrays.asList(new Person("Joe", 12), new Person("Jim", 34), new Person("John", 23));
        persons.sort((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        persons.forEach(p -> System.out.println(p.getFirstName()));
    }

    public static void test7() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);

        System.out.println(numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(", ")));
    }

    public static void test8() {
        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();
    }

    public static void test9() {
        List<Person> persons = Arrays.asList(new Person("Joe", 12), new Person("Aim", 34), new Person("John", 23));
        persons.stream()
                .map(Person::getFirstName)
                .filter(name -> name.startsWith("A"))
                .limit(10)
                .forEach(name -> System.out.println(name));
    }

    public static void test10() {
        IntStream.rangeClosed(1, 10).forEach(num -> System.out.print(num));
        System.out.println("\n==========");
        IntStream.range(1, 10).forEach(num -> System.out.print(num));
    }

    public static void test11() {
        Stream.of("This", "is", "Java8", "Stream").forEach(System.out::println);

        String[] stringArray = new String[]{"Streams", "can", "be", "created", "from", "arrays"};
        Arrays.stream(stringArray).forEach(System.out::println);
    }

    public static void test12() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("build.gradle"), StandardCharsets.UTF_8);
        //BufferedReader's lines methods returns a stream of all lines
        reader.lines().forEach(System.out::println);
    }

    public static void test13() {
        List<Person> persons = Arrays.asList(new Person("Joe", 12), new Person("Aim", 34), new Person("John", 23));
        Stream<String> streamOfNames = persons.stream()
                .map(person -> {
                    System.out.println("In Map - " + person.getFirstName());
                    return person.getFirstName();
                });
        //Just to add some delay
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " sec");
        }
        //Called a terminal operation on the stream
        streamOfNames.collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        test13();
    }
}
