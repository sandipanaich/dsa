package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> implements Sortable<T> {


    @Override
    public void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private int partition(T[] array, int start, int end) {

        int pivot = end;
        T element = array[pivot];
        end -= 1;

        while (start <= end) {
            if (array[start].compareTo(element) < 0)
                start++;
            else if (array[end].compareTo(element) > 0)
                end--;
            else {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        swap(array, start, pivot);

        return start;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 7, 5, 3, 9, 0, 6, 4, 8, 2};
        new QuickSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
