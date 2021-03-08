package com.xuan.algorithm.algorithm_java.sort;

import com.xuan.algorithm.algorithm_java.ArrayGenerator;
import com.xuan.algorithm.algorithm_java.SortingHelper;

import java.util.Arrays;

public class ShellSort {

    private ShellSort() {
    }

    /**
     * 希尔排序法
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] data) {

        int h = data.length / 2;

        while (h >= 1) {
                for (int i = h; i < data.length; i ++) {
                    E t = data[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }

            h /= 2;
        }
    }

    /**
     * 希尔排序法
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] data) {

        int h = 1;
        while (h < data.length) h = h * 3 + 1;

        while (h >= 1) {
            for (int i = h; i < data.length; i ++) {
                E t = data[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = t;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("MergeSort", arr);
            SortingHelper.sortTest("ShellSort", arr2);
            SortingHelper.sortTest("ShellSort2", arr3);

        }
    }
}
