package com.acubenchik.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {


    public static void main(String[] args) {
        new ArrayIntersection().intersection(new int[]{1,2,2,1}, new int[]{2,2});
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i  =0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) {
                j++;
            } else if(nums1[i] < nums2[j])  {
                i++;
            } else {
                if(res.isEmpty()) {
                    res.add(nums1[i]);
                } else if(!res.isEmpty() && res.get(res.size() - 1) != nums1[i]) {
                    res.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int  [] result = new int[res.size()];
        for(int e = 0; e < res.size(); e++) {
            result[e] = res.get(e);
        }
        return result;
    }
}
