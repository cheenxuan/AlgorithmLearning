package com.xuan.algorithm.leetcode;

public class Solution_704 {

    public static int search(int[] data, int target) {
        return search(data, 0, data.length - 1, target);
    }

    private static int search(int[] data, int l, int r, int target) {

        if (l > r) return -1;
        int mid = l + (r - l) / 2;

        if (data[mid] == target) return mid;

        if (data[mid]<target) return search(data, mid + 1, r, target);

        return search(data, l, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,9};
        int target = 10;

        System.out.println(search(arr,target));
    }
}
