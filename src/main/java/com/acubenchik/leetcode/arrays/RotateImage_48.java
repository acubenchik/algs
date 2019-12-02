package com.acubenchik.leetcode.arrays;

public class RotateImage_48 {

    public static void main(String[] args) {
        new RotateImage_48().rotate(new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    public void transpose(int [][] matrix) {
        for(int i = 0; i < matrix.length; i++)  {
            for(int j =i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseRows(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0, k = matrix[0].length - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
    }
}
