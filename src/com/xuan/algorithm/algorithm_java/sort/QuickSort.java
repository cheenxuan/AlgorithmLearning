package com.xuan.algorithm.algorithm_java.sort;

import com.xuan.algorithm.algorithm_java.ArrayGenerator;
import com.xuan.algorithm.algorithm_java.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
//        if (l >= r) return;

        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return; // 注意，这里要 return！
        }

        int p = partition(arr, l, r);

        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        //arr[l+1 ...j] < v;arr[j + 1 ... i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int p) {
        E t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {
//        if (l >= r) return;

        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return; // 注意，这里要 return！
        }

        int p = partition(arr, l, r, rnd);

        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd) {

        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, p, l);

        //arr[l+1 ...j] < v;arr[j + 1 ... i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        Random rnd = new Random();
        sort2ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random rnd) {
//        if (l >= r) return;

        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return; // 注意，这里要 return！
        }

        int p = partition2(arr, l, r, rnd);

        sort2ways(arr, l, p - 1, rnd);
        sort2ways(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random rnd) {

        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, p, l);

        //arr[l+1 ...j] <= v;arr[j + 1 ... i] >= v
        int i = l + 1, j = r;
        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) < 0 )
                i++;
            while(j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;

            if(i >= j) break;

            swap(arr,i,j);
            i++;
            j--;
        }

        swap(arr,l,j);

        return j;
    }

    public static void main(String[] args) {

//        Integer[] arr = {3, 9, 2, 8, 1, 5, 4, 6, 7};
//        QuickSort.sort(arr);
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        int[] dataSize = {100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//            Integer[] arr3 = ArrayGenerator.generateSpecialArray(n);
            SortingHelper.sortTest("QuickSort", arr);
            SortingHelper.sortTest("QuickSort2Ways", arr2);

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("QuickSort", arr);
            SortingHelper.sortTest("QuickSort2Ways", arr2);

            arr = ArrayGenerator.generateRandomArray(n, 1);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("QuickSort2Ways", arr2);
            SortingHelper.sortTest("QuickSort", arr);

        }
    }
}
