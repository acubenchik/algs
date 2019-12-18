package com.acubenchik.gs;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        if(nums[0] == 0) {
            return false;
        }
        boolean [] jumps = new boolean[nums.length];
        jumps[0] = true;
        for (int i = 1; i < nums.length; i++) {
            jumps[i] = false;
            for (int j = 0; j < i; j++) {
                if(i <= j + nums[j] && jumps[j]) {
                    jumps[i] = true;
                    break;
                }
            }
        }
        return jumps[nums.length - 1];
    }

    public static void main(String[] args) {
        boolean res = new JumpGame_55().canJump(new int[]{2,3,1,1,4});
        System.out.println(res);
    }
}
