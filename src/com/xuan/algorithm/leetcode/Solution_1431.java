package com.xuan.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();

        int maxVal = Arrays.stream(candies).max().getAsInt();

        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= maxVal);
        }
        return res;
    }
}
