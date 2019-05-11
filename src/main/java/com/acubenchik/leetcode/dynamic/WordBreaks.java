package com.acubenchik.leetcode.dynamic;


import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/word-break/
public class WordBreaks {

    public static void main(String[] args) {
        boolean res = new WordBreaks().wordBreak("catndog", Arrays.asList("cat",  "n", "dog"));
        System.out.println(res);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp =  new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = i; j >=0; j--) {
                if(dp[j]) {
                    if(wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];

    }


}
