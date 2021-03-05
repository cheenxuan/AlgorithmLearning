package com.xuan.algorithm.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 剑指offer 40
 */
public class TopK {

    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            Integer t = pq.peek();
            if (!pq.isEmpty() && arr[i] < t) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int k = 2;
        int[] s = new TopK().getLeastNumbers(a, k);

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }
}
