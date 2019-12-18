package com.acubenchik.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given a string, find the longest substring that contains only two unique characters.
//        For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
public class LongestSubstringWithKMostDistinctCharacters {

    public static void main(String[] args) {
        String res = new LongestSubstringWithKMostDistinctCharacters().longestSubstr("aabbcccddd", 2);
        System.out.println(res);
//        new LongestSubstringWithKMostDistinctCharacters().longestSubstr("aaabbc", 2);
    }

    public String find(String s, int k) {
        Map<Character,Integer> uniqueCharacters = new HashMap<>();
        int currentLeft = 0;
        int left = 0;
        int right = 0;
        for (int currentRight = 0; currentRight < s.length(); currentRight++) {
            char current = s.charAt(currentRight);
            if(uniqueCharacters.containsKey(current)) {
                uniqueCharacters.put(current, uniqueCharacters.get(current)+1);
            } else {
                uniqueCharacters.put(current, 1);
            }
               while(uniqueCharacters.size() > k) {
                   char charToRemove = s.charAt(currentLeft);
                   int count = uniqueCharacters.get(charToRemove);
                   if(count==1){
                       uniqueCharacters.remove(charToRemove);
                   }else{
                       uniqueCharacters.put(charToRemove, uniqueCharacters.get(charToRemove)-1);
                   }
                   currentLeft++;
            }
            if (right - left < currentRight - currentLeft)
            {
                right = currentRight;
                left = currentLeft;
            }

        }
        return s.substring(left, right + 1);
    }

    public static String longestSubstr(String str, int k)
    {
        // stores longest substring boundaries
        int end = 0, begin = 0;

        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();

        // count array to store frequency of characters present in
        // current window
        // we can also use a map instead of count array
        int[] freq = new int[256];

        // [low..high] maintain sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            window.add(str.charAt(high));
            freq[str.charAt(high)]++;

            // if window size is more than k, remove characters from the left
            while (window.size() > k)
            {
                // if the frequency of leftmost character becomes 0 after
                // removing it in the window, remove it from set as well
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }

                low++;		// reduce window size
            }

            // update maximum window size if necessary
            if (end - begin < high - low)
            {
                end = high;
                begin = low;
            }
        }

        // return longest substring found at str[begin..end]
        return str.substring(begin, end + 1);
    }
}
