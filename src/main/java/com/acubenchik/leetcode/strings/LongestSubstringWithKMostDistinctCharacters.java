package com.acubenchik.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given a string, find the longest substring that contains only two unique characters.
//        For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
public class LongestSubstringWithKMostDistinctCharacters {

    public int find(String s, int k) {
        Map<Character,Integer> uniqueCharacters = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(uniqueCharacters.containsKey(current)) {
                uniqueCharacters.put(current, uniqueCharacters.get(current)+1);
            } else {
                uniqueCharacters.put(current, 1);
            }
            if(uniqueCharacters.size() <=k) {
                result = Math.max(result, i - left +1);
            } else {
               while(uniqueCharacters.size() > k) {
                   char charToRemove = s.charAt(left);
                   int count = uniqueCharacters.get(charToRemove);
                   if(count==1){
                       uniqueCharacters.remove(charToRemove);
                   }else{
                       uniqueCharacters.put(charToRemove, uniqueCharacters.get(charToRemove)-1);
                   }
                   left++;
               }
            }
        }
        return result;
    }
}
