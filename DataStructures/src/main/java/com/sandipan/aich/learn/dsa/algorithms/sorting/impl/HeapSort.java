package com.sandipan.aich.learn.dsa.algorithms.sorting.impl;

import com.sandipan.aich.learn.dsa.algorithms.sorting.Sortable;

import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public void sort(T[] array) {

        MaxHeap heap = new MaxHeap(array);

        for(int index = array.length - 1; index > 0 ; index--)
            array[index] = heap.remove();
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{10, 7, 5, 3, 9, 0, 6, 4, 8, 2, 1};
        new HeapSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }

    class MaxHeap {
        MaxHeap(T[] array) {
            this.heap = array;
            this.length = array.length;
            heafipy();
        }

        public T remove() {
            T element = heap[0];
            int last = length - 1;
            swap(heap, 0, last);
            length -= 1;
            sink(0);
            return element;
        }

        private void heafipy() {

            for (int index = length / 2; index >= 0; index--) {
                sink(index);
            }
        }

        private void sink(int index) {

            T element = heap[index];

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            left = left < length ? left : index;
            right = right < length ? right : index;

            int max = less(heap[left], heap[right]) ? right : left;
            max = less(element, heap[max]) ? max : index;

            if (index != max) {
                swap(heap, index, max);
                sink(max);
            }
        }


        T[] heap;
        int length;
    }
}
