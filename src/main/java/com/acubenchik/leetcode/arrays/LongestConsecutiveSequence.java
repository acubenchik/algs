package com.acubenchik.leetcode.arrays;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        new LongestConsecutiveSequence().longestConsecutive(new int[]{100,4,200,1,3,2});
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int max = 0;
        int next = 0;
        int prev = 0;
        for(int i =0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                continue;
            }
             prev = nums[i]-1;
             next = nums[i] +1;
            while(set.contains(prev)) {
                set.remove(prev);
                prev--;
            }
            while(set.contains(next)) {
                set.remove(next);
                next++;
            }

        }
        return Math.max(max, next-prev-1);
    }


}
