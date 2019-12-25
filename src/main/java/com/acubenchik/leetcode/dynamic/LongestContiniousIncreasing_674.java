package com.acubenchik.leetcode.dynamic;

public class LongestContiniousIncreasing_674 {
    public int findLengthOfLCIS(int[] nums) {

        int anchor = 0;
        int answer = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                anchor = i;
            }
            answer = Math.max(answer, i - anchor + 1);
        }
        return answer;
    }
}
