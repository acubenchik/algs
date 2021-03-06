package com.acubenchik.leetcode.dynamic;


//198
//https://leetcode.com/problems/house-robber/
public class HouseRobber_198 {

    public int rob(int[] nums) {
        int [] result = new int [nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++) {
            result[i] = Math.max(nums[i]+result[i-2], result[i-1]);
        }
        return result[result.length - 1];
    }
}
