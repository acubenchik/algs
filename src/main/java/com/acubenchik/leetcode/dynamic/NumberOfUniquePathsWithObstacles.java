package com.acubenchik.leetcode.dynamic;

//https://leetcode.com/problems/unique-paths-ii/
public class NumberOfUniquePathsWithObstacles {

    public static void main(String[] args) {
        new NumberOfUniquePathsWithObstacles().uniquePathsWithObstacles(new int[][] {
                {0}
        });
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for(int i =0; i < obstacleGrid.length; i ++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                } else {
                    obstacleGrid[i][j] = 1;
                }
            }
        }
        int[][]result = obstacleGrid;
        for(int i =0; i < obstacleGrid.length; i ++) {
            for(int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == -1) {
                    result[i][j] = 0;
                }
                if(obstacleGrid[i][j] == 1) {
                    if(i==0 && j==0) { result[i][j] = 1;}
                    else {
                        result[i][j] = 0;
                    }
                    if(i-1 >= 0 && obstacleGrid[i-1][j]!=-1) {
                        result[i][j] += result[i-1][j];
                    }
                    if(j-1 >= 0 && obstacleGrid[i][j-1]!=-1) {
                        result[i][j] += result[i][j-1];
                    }
                }
            }
        }
        return result[result.length-1][result[0].length-1];
    }

}
