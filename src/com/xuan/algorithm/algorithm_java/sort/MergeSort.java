package com.xuan.algorithm.algorithm_java.sort;

import com.xuan.algorithm.algorithm_java.ArrayGenerator;
import com.xuan.algorithm.algorithm_java.SortingHelper;

import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        sort(arr, 0, arr.length - 1, 0);
//    }
//
//    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth) {
//
////        System.out.print(generateDepthString(depth));
////        System.out.println(String.format("MergeSort Array[%d, %d]", l, r));
//
//        if (l >= r) return;
//
//        //r + l 在32位机上有可能越界
////        int mid = (l + r) / 2;
//        int mid = l + (r - l) / 2;
//
//        sort(arr, l, mid, depth + 1);
//
//        sort(arr, mid + 1, r, depth + 1);
//
//        merge(arr, l, mid, r, depth);
//
////        System.out.print(generateDepthString(depth));
////        System.out.print(String.format("after merge[%d, %d]", l, r));
////        StringBuilder ret = new StringBuilder();
////        for (int i = 0; i < arr.length; i++) {
////            ret.append(arr[i] + " ");
////        }
////        System.out.println(ret.toString());
//    }

//    public static <E extends Comparable<E>> void sort2(E[] arr) {
//        sort2(arr, 0, arr.length - 1, 0);
//    }
//
//    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r, int depth) {
//        if (l >= r) return;
//
//        //r + l 在32位机上有可能越界
////        int mid = (l + r) / 2;
//        int mid = l + (r - l) / 2;
//
//        sort2(arr, l, mid, depth + 1);
//
//        sort2(arr, mid + 1, r, depth + 1);
//
//        //1.如果arr[mid + 1]的值大于arr[mid] 不执行merge
//        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
//            merge(arr, l, mid, r, depth);
//        }
//    }
//
//    public static <E extends Comparable<E>> void sort3(E[] arr) {
//        sort3(arr, 0, arr.length - 1, 0);
//    }
//
//    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r, int depth) {
////        if (l >= r) return;
//
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
//
//        //r + l 在32位机上有可能越界
////        int mid = (l + r) / 2;
//        int mid = l + (r - l) / 2;
//
//        sort3(arr, l, mid, depth + 1);
//
//        sort3(arr, mid + 1, r, depth + 1);
//
//        //1.如果arr[mid + 1]的值大于arr[mid] 不执行merge
//        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
//            merge(arr, l, mid, r, depth);
//        }
//    }
//
//    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, int depth) {
//
////        System.out.print(generateDepthString(depth));
////        System.out.println(String.format("MergeSort merge Array[%d, %d, %d]", l, mid, r));
//
//        //合并两个有序的区间arr[l,mid] 和 arr[mid + 1,r]
//        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
//
//        int i = l, j = mid + 1;
//        for (int k = l; k <= r; k++) {
//
//            if (i > mid) {
//                arr[k] = temp[j - l];
//                j++;
//            } else if (j > r) {
//                arr[k] = temp[i - l];
//                i++;
//            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
//                arr[k] = temp[i - l];
//                i++;
//            } else {
//                arr[k] = temp[j - l];
//                j++;
//            }
//        }
//    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;

        //r + l 在32位机上有可能越界
//        int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;

        sort(arr, l, mid, temp);

        sort(arr, mid + 1, r, temp);

        //1.如果arr[mid + 1]的值大于arr[mid] 不执行merge
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        //合并两个有序的区间arr[l,mid] 和 arr[mid + 1,r]
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] dataSize = {5000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("MergeSort", arr);


        }

//        Integer[] nums = {7, 1, 4, 2, 9, 6, 3, 5, 8};
//        SortingHelper.sortTest("MergeSort", nums);
    }
}
