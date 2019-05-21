package com.acubenchik.leetcode.hashmap;

import java.util.HashMap;

public class Jewels_And_Stones_771 {

    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> freqs = new HashMap<>();
        for (char c :  S.toCharArray()) {
            if(freqs.get(c) == null) {
                freqs.put(c, 1);
            } else {
                freqs.put(c,  freqs.get(c) + 1);
            }
        }
        int result = 0;
        for(char c : J.toCharArray()) {
            if(freqs.get(c) != null)
                result += freqs.get(c);
        }
        return result;
    }
}
