package com.acubenchik.leetcode.arrays;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public static void main(String[] args) {
        int res = new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(res);
    }
    public int trap(int[] height) {

        int res = 0 ;
        int [] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }
        for (int i = right.length-2; i >=0 ; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(right[i],left[i]) - height[i];
        }
        return res;
    }


}
