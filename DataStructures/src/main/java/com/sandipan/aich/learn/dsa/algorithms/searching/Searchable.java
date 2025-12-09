package com.sandipan.aich.learn.dsa.algorithms.searching;

@FunctionalInterface
public interface Searchable<T extends Comparable<T>> {

    boolean find(T element, T[] array);

    default boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    default boolean equal(T a, T b) {
        return a.compareTo(b) == 0;
    }

}
