package com.xuan.algorithm.leetcode;

import com.xuan.algorithm.datastructure.SegementTree;

public class NumArray {

    private SegementTree<Integer> segementTree;

    public NumArray(int[] nums) {
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        segementTree = new SegementTree<>(data, (a, b) -> a + b);
    }

    public void update(int index, int val) {
        segementTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        if(segementTree == null)
            throw new IllegalArgumentException("segementreee is null");
        return segementTree.query(i, j);
    }
}
