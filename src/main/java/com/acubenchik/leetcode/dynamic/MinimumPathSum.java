package com.acubenchik.leetcode.dynamic;

//      https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public static void main(String[] args) {
        int result = new MinimumPathSum().minPathSum(new int[][]{
                {1,3,1},
                {1,0,1},
                {4,2,1}
        });
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int [][]dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i== 0) {
                    if(j == 0) {
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                } else {
                    if(j==0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j]);
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }
}

