package com.xuan.algorithm.algorithm_java.linearsearch;

import com.xuan.algorithm.algorithm_java.model.ArrayGenerator;
import com.xuan.algorithm.algorithm_java.model.Student;

public class LinearSearch {

    private LinearSearch() {
    }

    private static <E> int search(E[] arr, E targetVal) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(targetVal))
                return i;
        return -1;
    }

//    public static void main(String[] args) {
//        Integer[] arr = {18, 27, 87, 46, 78, 98, 46, 13, 12};
//
//        int index = search(arr, 16);
//
//        if (index == -1) {
//            System.out.println("没有找到目标值");
//        } else {
//            System.out.println("找到目标值：" + arr[index] + ",在数组的索引为：" + index);
//        }
//
//
//        Student[] students = {new Student("张三", 17),new Student("Alex", 18),new Student("Mia", 17)};
//        Student alex = new Student("alex", 18);
//
//        int res = search(students, alex);
//        System.out.println(res);
//    }

    public static void main(String[] args) {

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {

            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++)
                LinearSearch.search(data, n);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs: " + time + "s");
        }
    }
}
