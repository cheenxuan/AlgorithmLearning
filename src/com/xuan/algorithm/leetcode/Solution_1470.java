package com.xuan.algorithm.leetcode;

public class Solution_1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];

        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n + i];
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int[] ret = new Solution_1470().shuffle(nums,4);
        System.out.println(ret.toString());
    }
}
