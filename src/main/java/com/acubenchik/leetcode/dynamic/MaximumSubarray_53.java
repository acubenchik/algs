
package com.acubenchik.leetcode.dynamic;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length ;i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for (int i=0; i<dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
