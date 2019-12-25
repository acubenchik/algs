package com.acubenchik.gs;

public class Knapsack_Equal_Sum_416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int el: nums) {
            sum += el;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int half = sum/2;

        boolean dp[][] = new boolean[nums.length][half + 1];
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for(int w = 0; w <= half; w++) {
            dp[0][w] = nums[0] == w;
        }
        for(int i =1; i < nums.length; i++) {
            for (int w = 0; w <= half; w++) {
                if(dp[i-1][w]) {
                    dp[i][w] = true;
                } else if(nums[i] <= w) {
                    dp[i][w] = dp[i-1][w-nums[i]];
                }
            }
        }

        return dp[nums.length - 1][half];
    }
}
