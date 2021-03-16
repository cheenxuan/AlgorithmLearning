package com.xuan.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_771 {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set<Character> J = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            J.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {
            if(J.contains(stones.charAt(i)))
                res++;
        }

        return res;
    }
}
