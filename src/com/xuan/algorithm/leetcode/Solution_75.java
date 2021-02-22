package com.xuan.algorithm.leetcode;

public class Solution_75 {

    public static void sortColors(int[] arr) {
        int zero = -1, i = 0, two = arr.length;
        while (i < two) {

            if(arr[i] == 0){
                zero++;
                swap(arr,i,zero);
                i++;
            } else if(arr[i] == 2){
                two--;
                swap(arr,i,two);
            }else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 0, 0, 1, 0, 2, 1, 2, 2, 1};

        sortColors(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
