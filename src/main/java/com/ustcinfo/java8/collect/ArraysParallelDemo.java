package com.ustcinfo.java8.collect;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by melin on 14-2-1.
 */
public class ArraysParallelDemo {
    public static void main(String[] args) throws FileNotFoundException {
        List<Double> arraySource = new ArrayList<>();

        Scanner reader = new Scanner(ClassLoader.
                getSystemResourceAsStream("java8demo/large_array_input"));
        while(reader.hasNext()){
            String line = reader.nextLine();
            String[] strNums = line.split(",");
            for ( String strN : strNums){
                arraySource.add(Double.parseDouble(strN));
            }
        }

        System.out.println(arraySource.size());

        Double [] myArray = new Double[1];
        myArray = arraySource.toArray(myArray);
        long startTime = System.currentTimeMillis();
        Arrays.sort(myArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Time take in serial: "+
                (endTime-startTime)/1000.0);

        Double [] myArray2 = new Double[1];
        myArray2 = arraySource.toArray(myArray);
        startTime = System.currentTimeMillis();
        Arrays.parallelSort(myArray2);
        endTime = System.currentTimeMillis();
        System.out.println("Time take in parallel: "+
                (endTime-startTime)/1000.0);

    }
}
