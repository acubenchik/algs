package com.acubenchik.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraSumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumNumber = new HashMap<>();
//        int [] prefixSums = new int[nums.length + 1];
        sumNumber.put(0, 1);
//        prefixSums[0] = 0;
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum +  nums[i];
            if(sumNumber.containsKey(currentSum-k)) {
                count += sumNumber.get(currentSum-k);
            }
            sumNumber.put(currentSum, sumNumber.getOrDefault(currentSum, 0) + 1);
//            prefixSums[i] = currentSum;

        }
        return count;


    }


}
