package com.acubenchik.leetcode;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresofSorted {

    public static void main(String[] args) {
        new SquaresofSorted().sortedSquares(new int[]{-1, -2});
    }

    public int[] sortedSquares(int[] A) {

        int zeroPosition = 0;
        int [] result = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= 0) {
                zeroPosition = i;
                break;
            }
        }

        int back = zeroPosition - 1;
        int forward = zeroPosition;
        int currentPos = 0;
        while(back >=0 && forward < A.length) {
            if(A[back]*A[back] < A[forward]*A[forward]) {
                result[currentPos++] = A[back]*A[back];
                back--;
            } else {
                result[currentPos++] = A[forward]*A[forward];
                forward++;
            }
        }
        while(back >=0) {
            result[currentPos++] = A[back]*A[back];
            back--;
        }
        while(forward < A.length) {
            result[currentPos++] = A[forward]*A[forward];
            forward++;
        }
        return result;
    }
}
