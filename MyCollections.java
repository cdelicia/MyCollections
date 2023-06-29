package com.collections;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCollections {
    private static final String RED_COLOR = "\033[1;31m";
    private static final String GREEN_COLOR = "\033[1;32m";
    private static final Collection<Integer> hashSet = new HashSet<>();
    private static final List<Integer> arrayList = new ArrayList<>();
    private static final Collection<Integer> treeSet = new TreeSet<>();


    public static void mergeTwoCollectionsUsingHashSet() {
        if (arrayList.isEmpty() || hashSet.isEmpty()) {
            System.out.println("Error: First of all call init methods for ArrayList and HashSet\n");
            return;
        }
        hashSet.addAll(arrayList);
        arrayList.clear();
    }

    public static void sortHashSetAfterMerging() {
        if (hashSet.size() == Main.SIZE_OF_HASHSET) {
            System.out.println("Error: Secondly call merge method for merging ArrayList and HashSet\n");
            return;
        }
        /**
         * Second solution via Arrays.class
         */
        Object[] newArray = hashSet.toArray();
        Arrays.sort(newArray);
        printResult(newArray);

        /**
         * Third solution via TreeSet.class
         */
        treeSet.addAll(hashSet);
        printResult(treeSet, "Solution #3: TreeSet after instantiation", GREEN_COLOR);
    }

    /**
     * First solution using Stream interface
     */
    public static void mergeAndSortUsingStream() {
        if (arrayList.isEmpty() || hashSet.isEmpty()) {
            System.out.println("Error: First of all call init methods for ArrayList and HashSet\n");
            return;
        }
        Stream<Integer> stream1 = hashSet.stream();
        Stream<Integer> stream2 = arrayList.stream();
        List<Integer> finalResult = Stream.concat(stream1, stream2).distinct().sorted().collect(Collectors.toList());
        printResult(finalResult, "Solution #1: New List using Streams", GREEN_COLOR);
    }


    /**
     * Overloaded Print Methods
     */
    public static void printResult(Collection<Integer> collection, String comment, String color) {
        System.out.println(color + comment + ", size=" + collection.size() + "\033[0m");
        System.out.println(collection);
        System.out.println();
    }

    private static void printResult(Object[] array) {
        System.out.println("\033[1;32mSolution #2: New array after sorting, size=" + array.length + "\033[0m");
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length-1)
                System.out.print(", ");
        }
        System.out.println("]\n");
    }

    /**
     * Collections Initialization Methods
     */
    public static void initOfArrayListByRandomValues() {
        Random random = new Random();

        for (int i = 0; i < Main.SIZE_OF_ARRAYLIST; i++) {
            arrayList.add(random.nextInt(Main.VARIETY_OF_ELEMENTS_IN_ARRAYLIST));
        }
        printResult(arrayList, "Original ArrayList in the very beginning", RED_COLOR);
    }

    public static void initOfHashSetByValues() {
        for (int i = 0; i < Main.SIZE_OF_HASHSET * Main.GAP_FOR_HASHSET; i += Main.GAP_FOR_HASHSET) {
            hashSet.add(i);
        }
        printResult(hashSet, "Original HashSet in the very beginning", RED_COLOR);
    }
}
