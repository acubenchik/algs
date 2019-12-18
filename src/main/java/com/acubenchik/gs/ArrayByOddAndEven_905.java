package com.acubenchik.gs;

import java.util.Collections;

public class ArrayByOddAndEven_905 {

    public int[] sortArrayByParity(int[] A) {
        if(A.length ==0 || A.length == 1) {
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        while(left < right) {
           while(A[left] % 2 == 0 && left < right) {
               left++;
           }
           while(A[right] % 2 != 0 && left < right) {
               right--;
           }
           if(left < right) {
               int temp = A[left];
               A[left] = A[right];
               A[right] = temp;
               left++;
               right--;
           }

        }
        return A;
    }
}
