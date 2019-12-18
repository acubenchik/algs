package com.acubenchik.gs;

public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int [] result = new int [n+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < result.length; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[result.length - 1];
    }
}
