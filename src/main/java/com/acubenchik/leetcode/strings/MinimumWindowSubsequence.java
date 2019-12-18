package com.acubenchik.leetcode.strings;

public class MinimumWindowSubsequence {

    public String minWindow(String s, String t) {
        int j = 0;
        int end = 0;
        int min = s.length() + 1;
        String windows = "";
        for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i) == t.charAt(j)) {
               j++;
               if(j >= t.length()) {
                   j--;
                   end = i+1;
                   while(j>=0) {
                      if(s.charAt(i) == t.charAt(j)) {
                          j--;
                      }
                      i--;
                   }
                   i++;
                   j++;
                   min = Math.min(end - i, min);
                   windows = s.substring(i, end);
               }
           }
        }
        return windows;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubsequence().minWindow("abddabcc", "abc"));
    }
}
