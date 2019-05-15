package com.acubenchik.leetcode.arrays;

//https://leetcode.com/problems/gas-station/
public class GasStations_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalRemaining = 0;
        int currentSumRemaining = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int currentRemaining = gas[i] - cost[i];
            if(currentSumRemaining < 0) {
                start = i;
                currentSumRemaining = currentRemaining;
            } else {
                currentSumRemaining += currentRemaining;
            }
            totalRemaining += currentRemaining;
        }
        if(totalRemaining < 0) {
            return -1;
        }
        return start;
    }
}
