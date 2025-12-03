package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> implements Sortable<T> {


    @Override
    public void sort(T[] array) {

        int len = array.length;
        int last = len - 1;

        for (int i = 1; i <= last; i++) {
            T value = array[i];
            int j = i - 1;

            while (j >= 0 && (value.compareTo(array[j]) < 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }

    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 7, 5, 3, 9, 0, 6, 4, 8, 2};
        new InsertionSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}

