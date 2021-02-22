package com.xuan.algorithm.leetcode;

import java.util.Arrays;
import java.util.Random;

public class SelectK {

    public int[] selectK(int[] arr,int k){
        Random rnd = new Random();

        int d =  selectK(arr,k,0,arr.length - 1,rnd);

        return Arrays.copyOfRange(arr, 0, d + 1);
    }

    private int selectK(int[] arr, int k, int l, int r, Random rnd) {
        if(l >= r) return l ;

        int p = l + rnd.nextInt(r-l + 1);
        swap(arr,l,p);

        int i = l+1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l]){
                i++;
            }
            while (j >= i && arr[j] > arr[l]){
                j--;
            }

            if(i >= j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr, l, j);

        if(arr[j] > k) return selectK(arr,k,l,j - 1,rnd);
        else if(arr[j] < k) return selectK(arr,k,j + 1,r,rnd);
        else return j;
    }

    public void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] a = {1,7,8,9,14,3,6,4,15,2,11,13,5,6,};
        int k = 6;

        int[] b = new SelectK().selectK(a,k);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }


    }
}
