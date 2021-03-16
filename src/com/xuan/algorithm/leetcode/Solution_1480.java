package com.xuan.algorithm.leetcode;

public class Solution_1480 {

    //一位数组的动态和
    public int[] runningSum(int[] nums) {

        int[] res = new int[nums.length];
        if(nums.length == 0) {
            return res;
        }

        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            res[i] = res[i - 1] + nums[i];

        return res;
    }


}
