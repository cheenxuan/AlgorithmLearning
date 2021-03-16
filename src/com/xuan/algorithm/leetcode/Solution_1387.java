package com.xuan.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_1387 {

    /**
     * 第一步： 计算权重 得出权重值
     * 第二部： 权重排序  相同的话按原升序排列  只能选择稳定排序:插入、冒泡、归并
     * 第三步：取出数组中第k个值
     */
    public int getKth(int lo, int hi, int k) {

        //创建权重数组
        int[] nums = new int[hi - lo + 1];
        int[] data = new int[hi - lo + 1];

        for (int i = 0; i < nums.length; i++) {
            data[i] = lo + i;
            nums[i] = calcPriority(lo + i);
        }
        //排序  稳定排序
//        insertSort(nums,data);
        bubbleSort(nums, data);

        return data[k - 1];
    }

    public int getKth2(int lo, int hi, int k) {

        memo = new HashMap<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int i = lo; i <= hi; i++) {
            heap.offer(new int[]{i, calcPriority(i)});
            if (heap.size() > k)
                heap.poll();
        }
        return heap.peek()[0];
    }

    private void bubbleSort(int[] nums, int[] data) {
        for (int i = 0; i + 1 < nums.length; ) {
            int lastSwppedIndex = 0;
            for (int j = 0; j + 1 < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swap(data, j, j + 1);
                    lastSwppedIndex = j + 1;
                }
            }
            i = data.length - lastSwppedIndex;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void insertSort(int[] nums, int[] data) {
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int d = data[i];
            int j;
            for (j = i; j - 1 >= 0 && t < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
                data[j] = data[j - 1];
            }
            nums[j] = t;
            data[j] = d;
        }
    }

    private Map<Integer, Integer> memo;

    private int calcPriority(int val) {
        if (val == 1) return 0;

        if (memo.containsKey(val)) {
            return memo.get(val);
        }

        int count = val % 2 == 0 ? calcPriority(val / 2) : calcPriority(3 * val + 1);

        count++;
        memo.put(val, count);

        return count;
    }


    public static void main(String[] args) {
        Solution_1387 s = new Solution_1387();
        System.out.println(s.getKth2(1, 1000, 777));
//        System.out.println(s.calcPriority(12));
    }
}
