package com.sandipan.aich.learn.dsa.algorithms.searching.impl;

import com.sandipan.aich.learn.dsa.algorithms.searching.Searchable;

public class LinearSearch<T extends Comparable<T>> implements Searchable<T> {

    @Override
    public boolean find(T element, T[] array) {

        for (int index = 0; index < array.length; index++) {

            if(equal(element, array[index]))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Searchable<Integer> finder = new LinearSearch<>();

        for (Integer i : array) {
            System.out.println("Found :: (" + i + ") ? " + finder.find(i, array));
        }

        System.out.println("Found :: (" + 11 + ") ? " + finder.find(11, array));
    }
}
