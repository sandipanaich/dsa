package com.sandipan.aich.learn.dsa.algorithms.searching.impl;

import com.sandipan.aich.learn.dsa.algorithms.searching.Searchable;

public class QuickSearch<T extends Comparable<T>> implements Searchable<T> {

    @Override
    public boolean find(T element, T[] array) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (less(array[mid], element)) {
                left = mid + 1;
            } else if (less(element, array[mid])) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Searchable<Integer> finder = new QuickSearch<>();

        for (Integer i : array) {
            System.out.println("Found :: (" + i + ") ? " + finder.find(i, array));
        }

        System.out.println("Found :: (" + 11 + ") ? " + finder.find(11, array));
    }
}
