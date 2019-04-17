package com.acubenchik.leetcode;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {0,0,0},
                {0, 1, 1}


        };
        fill(input, 1,1, input[1][1],1 );
    }

    public static void fill(int[][] grid, int i, int j, int targetColor, int newColor) {
        if(targetColor == newColor) {
            return;
        }
        int currentColor = getValueAt(grid, i, j);
        if(currentColor != targetColor) {
            return;
        }

            grid[i][j] = newColor;
            fill(grid, i - 1, j, targetColor, newColor);
            fill(grid, i + 1, j, targetColor, newColor);
            fill(grid, i, j - 1, targetColor, newColor);
            fill(grid, i, j + 1, targetColor, newColor);

    }

    private static int getValueAt(int[][] picture, int x, int y) {
        if (x < 0 || y < 0 || x >= picture.length || y >= picture[x].length) {
            return -1;
        } else {
            return picture[x][y];
        }
    }
}
