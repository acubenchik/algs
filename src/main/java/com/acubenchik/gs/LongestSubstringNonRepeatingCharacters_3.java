package com.acubenchik.gs;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) {
            return 1;
        }
        Set<Character> characters = new HashSet<>();
        int i = 0, j = 0;
        int answer = 0;
        while(i < s.length() && j < s.length()) {
            if(!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j));
                j++;
                answer = Math.max(answer, j - i);
            } else {
                characters.remove(s.charAt(i));
                i++;
            }
        }
        return answer;
    }
}
