package com.collections;

public class Main {
    public static final int VARIETY_OF_ELEMENTS_IN_ARRAYLIST = 70;
    public static final int SIZE_OF_ARRAYLIST = 20;
    public static final int GAP_FOR_HASHSET = 5;
    public static final int SIZE_OF_HASHSET = 20;

    public static void main(String[] args) {

        MyCollections.initOfHashSetByValues();
        MyCollections.initOfArrayListByRandomValues();

        MyCollections.mergeAndSortUsingStream();

        MyCollections.mergeTwoCollectionsUsingHashSet();
        MyCollections.sortHashSetAfterMerging();
    }
}
