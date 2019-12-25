package com.acubenchik.leetcode.dynamic;


//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence_300().lengthOfLIS(new int[]{1,3,5,4,7});
    }

    public int lengthOfLIS(int[] nums) {
        int answer = 0;
        int [] foundLengths = new int[nums.length];
        foundLengths[0] = 1;
        for (int i = 1; i < nums.length; i++) {

            int maxLenght = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxLenght = Math.max(maxLenght, foundLengths[j]);
                }

            }
            foundLengths[i] = maxLenght + 1;
            answer = Math.max(answer, foundLengths[i]);
        }
        return answer;
    }

}
