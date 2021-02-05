package com.xuan.algorithm.leetcode;

public class Solution_51 {

    private int res = 0;

    public int reversePairs(int[] nums) {
        res = 0;
        int[] temp = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1, temp);
    }

    private int reversePairs(int[] nums, int l, int r, int[] temp) {
        if (l >= r) return 0;

        int res = 0;
        int mid = l + (r - l) / 2;

        res += reversePairs(nums, l, mid, temp);

        res += reversePairs(nums, mid + 1, r, temp);
        if(nums[mid] > nums[mid + 1])
            res += mergeSort(nums, l, mid, r, temp);

        return res;
    }

    private int mergeSort(int[] nums, int l, int mid, int r, int[] temp) {

        System.arraycopy(nums, l, temp, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        int res = 0;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                res += mid - i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        int res = new Solution_51().reversePairs(nums);
        System.out.println(res);
    }


}
