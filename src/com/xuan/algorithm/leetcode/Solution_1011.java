package com.xuan.algorithm.leetcode;


import java.util.Arrays;

public class Solution_1011 {

    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt(),
                r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (days(weights, mid) > D)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    private int days(int[] weights, int mid) {
        int t = 0;
        int i = 0;
        int res = 0;

        while (i < weights.length){
            t += weights[i];
            if(t > mid){
                res ++;
                t = 0;
            }else{
                i ++;
            }
        }
        if(t > 0) res ++;

        return res;
    }


    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;

        System.out.println(new Solution_1011().shipWithinDays(weights, D));
//        int days = new Solution_1011().days(weights, 14);
//        System.out.println(days);

    }
}
