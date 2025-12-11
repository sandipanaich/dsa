package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorting {

    private static class SelectionSort<T extends Comparable<T>> implements Sortable<T> {

        @Override
        public void sort(T[] array) {

            int length = array.length;
            int last = length - 1;

            for (int i = 0; i < last; i++) {

                int min = i;

                for (int j = i + 1; j < length; j++) {
                    if (less(array[j], array[min])) {
                        min = j;
                    }
                }
                swap(array, i, min);
            }
        }
    }

    private static class BubbleSort<T extends Comparable<T>> implements Sortable<T> {

        @Override
        public void sort(T[] array) {

            int length = array.length;
            int last = length - 1;

            for (int i = 0; i < last; i++) {
                for (int j = 0; j < last - i; j++) {

                    if (less(array[j], array[j + 1])) {
                        swap(array, j, j++);
                    }
                }
            }
        }
    }

    public static class InsertionSort<T extends Comparable<T>> implements Sortable<T> {

        @Override
        public void sort(T[] array) {

            int length = array.length;

            for (int i = 1; i < length; i++) {

                T temp = array[i];
                int j = i - 1;

                while (j >= 0 && less(temp, array[j])) {
                    array[j + 1] = array[j];
                    j -= 1;
                }

                array[j + 1] = temp;
            }
        }
    }

    public static class MergeSort<T extends Comparable<T>> implements Sortable<T> {

        @Override
        @SuppressWarnings("unchecked")
        public void sort(T[] array) {

            int length = array.length;
            int last = length - 1;
            T[] aux = (T[]) Array.newInstance(array[0].getClass(), length);
            sort(array, 0, last, aux);
        }

        private void sort(T[] array, int start, int end, T[] aux) {

            if (start >= end) {
                return;
            }

            int mid = (start + end) / 2;
            sort(array, start, mid, aux);
            sort(array, mid + 1, end, aux);
            merge(array, start, mid, end, aux);
        }

        private void merge(T[] array, int start, int mid, int end, T[] aux) {

            int index = start;
            int left = start;
            int right = mid + 1;

            while (true) {

                if (left > mid && right > end) {
                    break;
                } else if (left > mid) {
                    aux[index++] = array[right++];
                } else if (right > end) {
                    aux[index++] = array[left++];
                } else {

                    if (less(array[left], array[right])) {
                        aux[index++] = array[left++];
                    } else {
                        aux[index++] = array[right++];
                    }
                }
            }
            System.arraycopy(aux, start, array, start, end - start + 1);
        }
    }

    public static class QuickSort<T extends Comparable<T>> implements Sortable<T> {

        @Override
        public void sort(T[] array) {

            int length = array.length;
            int last = length - 1;
            sort(array, 0, last);
        }

        private void sort(T[] array, int start, int end) {

            if (start > end) {
                return;
            }

            int pivot = partition(array, start, end);
            sort(array, start, pivot - 1);
            sort(array, pivot + 1, end);
        }

        int partition(T[] array, int start, int end) {

            int left = start;
            int right = end - 1;

            while (left < right) {

                if (less(array[left], array[end])) {
                    left++;
                } else if (less(array[end], array[end])) {
                    right--;
                } else {
                    swap(array, left, right);
                }
            }
            swap(array, left, end);
            return start;
        }
    }

    public static class HeapSort<T extends Comparable<T>> implements Sortable<T> {

        @Override
        public void sort(T[] array) {
            MaxHeap heap = new MaxHeap(array);
            int length = array.length;
            int last = length - 1;

            for (int index = last; index > 0; index--) {
                array[index] = heap.remove();
            }
        }

        class MaxHeap {

            MaxHeap(T[] array) {
                this.heap = array;
                this.length = array.length;
                heapify();
            }

            private void heapify() {

                for (int i = length / 2; i >= 0; i--) {
                    sink(i);
                }
            }

            private T remove() {

                T element = heap[0];
                swap(heap, 0, length - 1);
                length--;
                sink(0);
                return element;
            }

            private void sink(int index) {

                int left = index * 2 + 1;
                int right = index * 2 + 2;

                left = (left < length) ? left : index;
                right = (right < length) ? right : index;

                int max = (less(heap[left], heap[right])) ? right : left;
                max = less(heap[index], heap[max]) ? max : index;

                if (index != max) {
                    swap(heap, index, max);
                    sink(max);
                }
            }

            private final T[] heap;
            private int length;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{10, 7, 5, 3, 9, 0, 6, 4, 8, 2, 1};

        new SelectionSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));

        new BubbleSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));

        new InsertionSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));

        new MergeSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));

        new QuickSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));

        new HeapSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
