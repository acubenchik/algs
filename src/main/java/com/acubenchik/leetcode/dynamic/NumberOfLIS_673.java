package com.acubenchik.leetcode.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfLIS_673 {

    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);
        Arrays.fill(lengths, 1);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) if (nums[j] < nums[i]) {
                if (lengths[j] >= lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    counts[i] = counts[j];
                } else if (lengths[j] + 1 == lengths[i]) {
                    counts[i] += counts[j];
                }
            }
        }


        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //13547
        new NumberOfLIS_673().findNumberOfLIS(new int[]{1,3,5,4,7});
    }

}
