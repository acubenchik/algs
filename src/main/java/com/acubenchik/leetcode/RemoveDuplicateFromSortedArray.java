package com.acubenchik.leetcode;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        new RemoveDuplicateFromSortedArray().removeDuplicates(new int[]{1,1,2});
    }

    public int removeDuplicates(int[] nums) {
        int i =1;
        int j =0;
        while(i < nums.length) {
            if(nums[i] == nums[j]){
              i++;
            } else {
                nums[j+1] = nums[i];
                i++;
                j++;
            }

        }
        return j;

    }


}
