package com.xuan.algorithm.algorithm_java.sort;

import com.xuan.algorithm.algorithm_java.ArrayGenerator;
import com.xuan.algorithm.algorithm_java.SortingHelper;
import com.xuan.algorithm.datastructure.MaxHeap;

import java.util.Arrays;

public class HeapSort {

    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data)
            maxHeap.add(e);

        for (int i = data.length - 1; i >= 0; i--)
            data[i] = maxHeap.extracMax();
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {


        if (data.length <= 1) return;
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        for (int i = data.length - 1; i >= 0 ; i--) {
            swap(data, 0, i);
            siftDown(data,0, i);
        }


//        for (int i = data.length - 1; i > 0; i--) {
//            if (i == data.length - 1)
//                heapify(data, i);
//            else siftDown(data, 0, i);
//            swap(data, 0, i);
//        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) >= 0)
                break;

            swap(data, j, k);
            k = j;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        SortingHelper.sortTest("HeapSort", arr4);
        SortingHelper.sortTest("HeapSort2", arr5);


//       arr = ArrayGenerator.generateOrderedArray(n);
//       arr2 = Arrays.copyOf(arr, arr.length);
//       arr3 = Arrays.copyOf(arr, arr.length);
//       arr4 = Arrays.copyOf(arr, arr.length);

    }
}
