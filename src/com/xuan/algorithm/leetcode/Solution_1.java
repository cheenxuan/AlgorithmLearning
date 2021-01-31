package com.xuan.algorithm.leetcode;

import java.util.HashMap;

public class Solution_1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (temp.get(target - nums[i]) == null) {
                temp.put(nums[i], i);
            } else {
                return new int[]{i, temp.get(target - nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] data = twoSum(nums, target);
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < data.length; i++) {
            res.append(data[i]);
            if(i != data.length -1)
                res.append(", ");
        }
        res.append(']');
        System.out.println(res.toString());
    }

}
