package com.acubenchik.leetcode;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int[][]dp = new int[A.length+1][B.length+1];
        int res = 0;
        for (int i = A.length-1; i >=0; i--) {
            for (int j = B.length-1; j >=0; j--) {
                if(A[i]==B[j]){
                    dp[i][j] = dp[i+1][j+1] +1;
                    if(res < dp[i][j]) res = dp[i][j];
                }
            }
        }
        return res;
    }
}
