package com.acubenchik.leetcode.dynamic;


//https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum_931 {

    public static void main(String[] args) {
        new MinimumFallingPathSum_931().minFallingPathSum(new int[][]{
                {-84, -36, 2},
                {87, -79, 10},
                {42, 10, 63}
        });
    }

    public int minFallingPathSum(int[][] A) {
        int [][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(i==0) dp[i][j] = A[i][j];
                else {
                    if(j==0) {
                        dp[i][j] = Math.min(dp[i-1][j]+A[i][j], dp[i-1][j+1]+A[i][j]);
                    } else if (j == A[0].length-1) {
                        dp[i][j] = Math.min(dp[i-1][j]+A[i][j], dp[i-1][j-1]+A[i][j]);
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j]+A[i][j], Math.min(dp[i-1][j+1]+A[i][j],  dp[i-1][j-1]+A[i][j]));
                    }

                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < A[0].length; i++) {
          if(dp[A.length-1][i] < result) {
              result = dp[A.length-1][i];
          }
        }
        return result;

    }


}
