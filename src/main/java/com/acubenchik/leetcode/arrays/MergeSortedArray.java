package com.acubenchik.leetcode.arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int firstSize = m+n-1;
        int first = m -1;
        int secod = n-1;
        while(first>=0 && secod>=0) {
            nums1[firstSize--] = nums1[first] > nums2[secod] ? nums1[first--] : nums2[secod--];
        }
    }
}
