package com.xuan.algorithm.algorithm_java.sort;

import com.xuan.algorithm.algorithm_java.SortingHelper;
import com.xuan.algorithm.algorithm_java.ArrayGenerator;

public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //arr[0...i)是有序的；arr[i...n)是无序的
        for (int i = 0; i < arr.length; i++) {

            //选择arr[i...n)中的最小值的索引
            int minPos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minPos]) < 0)
                    minPos = j;
            }

            swap(arr, i, minPos);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
//        Integer[] arr = {16, 56, 67, 45, 1, 5, 7, 9, 3, 54, 86};
//        SelectionSort.sort(arr);
//        for (int e : arr) {
//            System.out.print(e + " ");
//        }
//
//        System.out.println("");
//        Student[] students = {new Student("Alex", 123),
//                new Student("Mia", 111),
//                new Student("Chirs", 156)};
//        SelectionSort.sort(students);
//        for (Student stu : students) {
//            System.out.println(stu);
//        }

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }


    }
}
