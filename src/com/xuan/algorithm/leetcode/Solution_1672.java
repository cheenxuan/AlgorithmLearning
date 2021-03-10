package com.xuan.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_1672 {

    public int maximumWealth(int[][] accounts) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < accounts.length; i++) {
            queue.add(Arrays.stream(accounts[i]).sum());
        }

        return queue.remove();

//        return Arrays.stream(accounts).map(s -> Arrays.stream(s).sum()).max(Comparator.comparingInt(Integer::intValue)).get();
    }

}
