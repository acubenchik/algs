package com.acubenchik.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int curr = target - nums[i];
            if(map.containsKey(curr) && map.get(curr) != i) {
                return new int[]{   i, map.get(curr)};
            }
        }
        throw new IllegalArgumentException("not found");
    }
}
