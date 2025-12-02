package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public void sort(T[] array) {

        int len = array.length;
        int last = len - 1;

        for (int i = last; i > 0; i--) {
            int max = i;
            for (int j = 0; j <= i - 1; j++) {
                if (array[max].compareTo(array[j]) < 0) {
                    max = j;
                }
            }
            swap(array, max, i);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 7, 5, 3, 9, 0, 6, 4, 8, 2};
        new BubbleSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
