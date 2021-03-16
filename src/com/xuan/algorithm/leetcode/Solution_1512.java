package com.xuan.algorithm.leetcode;

public class Solution_1512 {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] == nums[j])
                    res++;
        }

        return res;
    }
}
