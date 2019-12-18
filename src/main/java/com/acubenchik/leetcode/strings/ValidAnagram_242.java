package com.acubenchik.leetcode.strings;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int [] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++) {
            freqs[t.charAt(i)]--;
            if(freqs[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
