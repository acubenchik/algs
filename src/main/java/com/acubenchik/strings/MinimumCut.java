package com.acubenchik.strings;

//https://leetcode.com/problems/palindrome-partitioning-ii/

public class MinimumCut {

    public static void main(String[] args) {
        new MinimumCut().minCut("aab");
    }

    public int minCut(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int [] cut = new int[s.length()];
            boolean [][] isPalindrome = new boolean[s.length()][s.length()];
            for (int i = 1; i < s.length(); i++) {
                int min = i;
                for (int j = 0; j <= i; j++) {
                    if(s.charAt(i) == s.charAt(j) && (i <= j+1 || isPalindrome[i-1][j+1])) {
                        isPalindrome[i][j] = true;
                        min = Math.min(min, j == 0 ? 0 : 1 + cut[j-1]);
                    }
                }
                cut[i] = min;
            }
            return cut[s.length()-1];
        }
    }
