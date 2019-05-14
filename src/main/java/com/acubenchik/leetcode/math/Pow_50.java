package com.acubenchik.leetcode.math;

public class Pow_50 {

    public double myPow(double x, int n) {
        if(n == 0 ) return 1;
        if(n == 1) return x;
        if (n == Integer.MAX_VALUE && (x>1 || x<-1)) return 0.0;
        if (n == Integer.MIN_VALUE) {
            if (x == 0.0) return 0.0;
            if (x == 1.0) return 1.0;
            if (x == -1.0) return 1.0;
            return 0.0;
        }
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        if(n % 2 ==0) {
            return myPow(x*x, n/2);
        } else {
            return x*myPow(x*x, n/2);
        }

    }
}
