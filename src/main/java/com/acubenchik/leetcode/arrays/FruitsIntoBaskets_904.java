package com.acubenchik.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets_904 {

    public static void main(String[] args) {
        int res = new FruitsIntoBaskets_904().totalFruit(new int[]{1,2,3,2,2});
        System.out.println(res);
    }

    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int currentLeft = 0;
        int max = 0;
        for(int currentRight = 0; currentRight < tree.length; currentRight++) {
            if(map.get(tree[currentRight]) == null) {
                map.put(tree[currentRight], 1);
            } else {
                map.put(tree[currentRight], map.get(tree[currentRight]) + 1);
            }
            while(map.size() > 2) {
                int current = tree[currentLeft];
                int count = map.get(current);
                if(count == 1) {
                    map.remove(current);
                } else {
                    map.put(current, --count);
                }
                currentLeft++;

            }
            max = Math.max(max, currentRight - currentLeft + 1);
        }
       return max ;

    }
}
