package com.acubenchik.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int current = Integer.MIN_VALUE;
        int answer = 0;
        for(int[] pair : pairs) {
            if(current < pair[0]) {
                current = pair[1];
                answer++;
            }

        }
        return answer;
    }

}
