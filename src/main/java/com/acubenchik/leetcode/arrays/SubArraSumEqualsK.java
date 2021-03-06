package com.acubenchik.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraSumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumNumber = new HashMap<>();
        sumNumber.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum +  nums[i];
            if(sumNumber.containsKey(currentSum-k)) {
                count += sumNumber.get(currentSum-k);
            }
            sumNumber.put(currentSum, sumNumber.getOrDefault(currentSum, 0) + 1);

        }
        return count;


    }


}
