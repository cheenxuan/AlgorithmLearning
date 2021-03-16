package com.xuan.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        Map<String, Integer> map = new HashMap<>();
        map.put("type",0);
        map.put("color",1);
        map.put("name",2);

        int res = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(map.get(ruleKey))))
                res++;
        }
        return res;
    }
}
