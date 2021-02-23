package com.xuan.algorithm.algorithm_java.binarysearch;

public class BinarySearch {

    public BinarySearch() {
    }

    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if (l > r) return -1;
        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0)
            return mid;
        if (data[mid].compareTo(target) < 0)
            return searchR(data, mid + 1, r, target);
        return searchR(data, l, mid - 1, target);
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0)
                return mid;
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static <E extends Comparable<E>> int upper(E[] data, E target) {
//        return upper(data,0,data.length,target);
        int l = 0, r = data.length;
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static <E extends Comparable<E>> int upperR(E[] data, E target) {
        return upperR(data, 0, data.length, target);
    }

    private static <E extends Comparable<E>> int upperR(E[] data, int l, int r, E target) {
        if (l == r) return l;
        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) <= 0)
            return upperR(data, mid + 1, r, target);
        return upperR(data, l, mid, target);
    }

    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0)
            return u - 1;
        return u;
    }

    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0, r = data.length;
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
        int l = lower(data, target);
        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0)
            return l + 1;
        return l;
    }

    public static <E extends Comparable<E>> int upper_floor(E[] data, E target){
        int l = -1, r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    //二分查找模板

    /**
     *   ***是替换内容
     *
     *  int l = ***, r = ***;
     *
     *  在data[l,r]中寻找解
     *  while(l < r){
     *      int mid = l + (r - l) / 2;  l + (r - l + 1) / 2;
     *      if(data[mid].compareTo(target) *** 0)
     *          l = ***;
     *      else
     *          r = ***;
     *  }
     *
     *  return l;
     *
     */

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lower(arr, i) + " ");
            System.out.println();
        }
    }
}
