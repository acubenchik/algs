package com.acubenchik.leetcode;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int totalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > 0) {
                currentMax = Math.max(currentMax * nums[i], nums[i]);
                currentMin = Math.min(currentMin* nums[i], nums[i]);
            } else {
                int currentMaxTemp = Math.max(nums[i], currentMin * nums[i]);
                currentMin = Math.min(currentMax * nums[i], nums[i]);
                currentMax = currentMaxTemp;
            }
            totalMax = Math.max(currentMax, totalMax);
        }
        return totalMax;
    }
}
