package com.xuan.algorithm.algorithm_java.sort;

import com.xuan.algorithm.algorithm_java.ArrayGenerator;
import com.xuan.algorithm.algorithm_java.SortingHelper;

import java.util.Arrays;

public class BubbleSort {

    private BubbleSort(){}

    public static <E extends Comparable<E>> void sort(E[] data) {

        for (int i = 0; i + 1 < data.length; i++) {
            for (int j = 0; j + 1 < data.length - i; j++) {
                if(data[j].compareTo(data[j + 1]) > 0)
                    swap(data, j, j + 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        for (int i = 0; i + 1 < data.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j + 1 < data.length - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {

        for (int i = 0; i + 1 < data.length; ) {
            int lastSwppedIndex = 0;
            for (int j = 0; j + 1 < data.length - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwppedIndex = j + 1;
                }
            }
            i = data.length - lastSwppedIndex;
        }
    }

    public static <E extends Comparable<E>> void sort4(E[] data) {

        for (int i = 0; i + 1 < data.length; ) {
            int lastSwppedIndex = data.length - 1;
            for (int j = data.length - 1; j > i; j--) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    swap(data, j, j - 1);
                    lastSwppedIndex = j - 1;
                }
            }
            i = lastSwppedIndex + 1;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("BubbleSort",arr);
        SortingHelper.sortTest("BubbleSort2",arr2);
        SortingHelper.sortTest("BubbleSort3",arr3);
        SortingHelper.sortTest("BubbleSort4",arr4);

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("BubbleSort",arr);
        SortingHelper.sortTest("BubbleSort2",arr2);
        SortingHelper.sortTest("BubbleSort3",arr3);


    }
}
