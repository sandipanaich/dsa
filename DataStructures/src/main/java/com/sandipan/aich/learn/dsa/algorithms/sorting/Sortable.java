package com.sandipan.aich.learn.dsa.algorithms.sorting;

@FunctionalInterface
public interface Sortable<T extends Comparable<T>> {

    void sort(T[] array);

    default void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    default boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
