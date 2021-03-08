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

            for (int start = 0; start < h; start++) {

                for (int i = start + h; i < data.length; i += h) {
                    E t = data[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("MergeSort", arr2);
            SortingHelper.sortTest("ShellSort", arr3);

        }
    }
}
