package com.acubenchik.gs;

public class JumpGame_45 {

    public int jump(int[] nums) {
        int [] jumps = new int[nums.length];
        jumps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(i <= j + nums[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[nums.length - 1];
    }
}
