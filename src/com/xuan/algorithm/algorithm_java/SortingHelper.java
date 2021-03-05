package com.xuan.algorithm.algorithm_java;

import com.xuan.algorithm.algorithm_java.sort.*;

public class SortingHelper {

    private SortingHelper() {
    }

    /**
     * 判断排序数组是否已排序
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {

        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortName.equals("InsertionSort"))
            InsertionSort.sort(arr);
        else if(sortName.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortName.equals("MergeSortBU"))
            MergeSort.sortBU(arr);
        else if(sortName.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortName.equals("QuickSort2Ways"))
            QuickSort.sort2ways(arr);
        else if(sortName.equals("QuickSort3Ways"))
            QuickSort.sort3ways(arr);
        else if(sortName.equals("HeapSort"))
            HeapSort.sort(arr);
        else if(sortName.equals("HeapSort2"))
            HeapSort.sort2(arr);
        else if(sortName.equals("BubbleSort"))
            BubbleSort.sort(arr);
        else if(sortName.equals("BubbleSort2"))
            BubbleSort.sort2(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortName + " failed!");
        System.out.println(String.format("%s, n = %d, time = %fs", sortName, arr.length, time));
    }
}
