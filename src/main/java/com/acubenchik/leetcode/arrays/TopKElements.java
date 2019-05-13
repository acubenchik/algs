package com.acubenchik.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> [] buckets = new List[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
        }
        for(int el: frequencies.keySet()) {
            int frequency = frequencies.get(el);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(el);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length-1; i >=0 && result.size() < k; i--) {
            if(buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        return result;
    }
}
