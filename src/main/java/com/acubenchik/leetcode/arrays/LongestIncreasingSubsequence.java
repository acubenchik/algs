package com.acubenchik.leetcode.arrays;


//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,5,4,7});
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int answer = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
                dp[i] = max + 1;
                answer = Math.max(answer, dp[i]);
            }
        }
        return answer;
    }
}
