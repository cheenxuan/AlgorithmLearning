package com.xuan.algorithm.leetcode;

import java.util.Arrays;

public class Solution_875 {

    public static int minEatingSpeed(int[] piles,int H){

        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l < r){
            int mid = l + (r - l) / 2;
            if(eatTime(piles,mid) <= H)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private static int eatTime(int[] piles,int k){
        int h = 0;
        for (int pile : piles) {
            h += pile / k;
            if (pile % k > 0)
                h++;
        }
        return h;
    }
}
