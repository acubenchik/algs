package com.acubenchik.leetcode.dynamic;


//https://leetcode.com/problems/paint-house/#/description
public class PaintingHouse {

    public int minCost(int[][] costs) {
        int startRed = 0;
        int startBlue = 0;
        int startGreen = 0;
        for (int i = 0; i < costs.length; i++) {
            int red = costs[i][0] + Math.min(startBlue, startGreen);
            int blue = costs[i][1] + Math.min(startRed, startGreen);
            int green = costs[i][2] + Math.min(startBlue, startRed);
            startRed = red;
            startBlue = blue;
            startGreen = green;

        }
        return Math.max(startRed, Math.max(startBlue, startGreen));
    }
}
