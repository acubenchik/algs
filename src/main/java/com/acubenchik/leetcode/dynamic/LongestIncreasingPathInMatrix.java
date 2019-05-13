package com.acubenchik.leetcode.dynamic;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][]dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i=0; i<matrix.length; i++)
            for (int j=0; j<matrix[0].length; j++)
                ans = Math.max(ans, dp(matrix, dp, i, j));
        return ans;

    }

    int dp(int[][]matrix, int[][] dp, int i, int j) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        if(dp[i][j] > 0) return dp[i][j];
        dp[i][j] = 1;
        for(int k =0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                dp[i][j] = Math.max(dp[i][j], 1+ dp(matrix, dp, x, y));
            }
        }
        return dp[i][j];
    }
}
