package com.acubenchik.leetcode.dynamic;

//https://leetcode.com/problems/unique-paths/
public class NumberOfUniquePaths {
    public static void main(String[] args) {
        new NumberOfUniquePaths().uniquePaths(3,2);
    }
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) {
            return 1;
        }
        int[][] result = new int[n][m];
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = 1;
            }
        }
        result[0][0] = 0;
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j++){
                result[i][j] = 0;
                if(i-1 >= 0) {
                    result[i][j] += result[i - 1][j];
                }
                if(j-1 >= 0) {
                    result[i][j] += result[i][j-1];
                }
            }
        }
        return result[n-1][m-1];
    }
}
