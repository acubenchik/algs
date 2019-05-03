package com.acubenchik.leetcode;


import java.util.Arrays;

//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
public class SplitArrayIntoThreePartsEqualSum {
    public static void main(String[] args) {
        boolean res = new SplitArrayIntoThreePartsEqualSum().canThreePartsEqualSum(new int[]{1,-2,2, 3,2,5});
        System.out.println(res);
    }

    public boolean canThreePartsEqualSum(int[] A) {

        int sum = Arrays.stream(A).sum();
        int part = sum/3;
        if(sum%3 != 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        int i = 0;
        int j = A.length - 1;
        boolean leftFound = false;
        boolean rightFound = false;
        while(j>i) {
            if(!leftFound) left +=A[i];
            if(!rightFound) right +=A[j];
            if(left == right && right == part) {
                return (sum-left-right) == part;
            }
            if(left != part) {
                i++;
            } else  {
                leftFound = true;
            }
            if(right != part) {
                j--;
            } else {
                rightFound = true;
            }
        }
//        for(int i =0, j = A.length-1; i< A.length; i++) {
//            if(A[i] < A[j]) {
//                continue;
//            } else {
//
//            }
//        }
        return false;
    }
}
