package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array) {

        int last = array.length - 1;
        T[] aux = (T[]) Array.newInstance(array[0].getClass(), array.length);
        sort(array, 0, last, aux);
    }

    public void sort(T[] array, int start, int end, T[] aux) {

        if (start >= end)
            return;

        int mid = (start + end) / 2;

        sort(array, start, mid, aux);
        sort(array, mid + 1, end, aux);
        merge(array, start, mid, end, aux);
    }

    public void merge(T[] array, int start, int mid, int end, T[] aux) {

        int left = start;
        int right = mid + 1;

        int index = start;

        while (true) {

            if(left > mid && right > end)
                break;
            else if (left > mid) {
                aux[index++] = array[right++];

            } else if (right > end) {
                aux[index++] = array[left++];

            } else {

                if (array[left].compareTo(array[right]) < 0)
                    aux[index++] = array[left++];
                else
                    aux[index++] = array[right++];
            }
        }
        System.arraycopy(aux, start, array, start, end - start + 1);
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 7, 5, 3, 9, 0, 6, 4, 8, 2};
        new MergeSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
