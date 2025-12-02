package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public void sort(T[] array) {

        int len = array.length;
        int last = len - 1;

        for (int i = 0; i < last; i++) {

            int min = i;
            T value = array[i];

            for (int j = i + 1; j <= last; j++) {
                if (value.compareTo(array[j]) > 0) {
                    min = j;
                    value = array[j];
                }
            }
            swap(array, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 7, 5, 3, 9, 0, 6, 4, 8, 2};
        new SelectionSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
