package com.acubenchik.leetcode.strings;

//https://www.geeksforgeeks.org/count-pairs-of-non-overlapping-palindromic-sub-strings-of-the-given-string/
//https://asdfcoding.wordpress.com/2013/06/03/d-palindrome-pairs-codeforces/
public class NonOverlappingPalindromePairs {

    public static void main(String[] args) {
        new NonOverlappingPalindromePairs().numOfPairs("abacaba");
    }


    public int numOfPairs(String s) {
        boolean[][] isPalindrome = palindromeMatrix(s);

        int [] numOfPalindromsStartingAtIPosition = new int [s.length()+1];
        int [] dp = new int [s.length()];
        for (int i=0 ; i<s.length() ; i++) {
            for (int j=i ; j<s.length() ; j++)
                numOfPalindromsStartingAtIPosition[i] += isPalindrome[i][j] ? 1 : 0;
        }


//        int longAnswer = 0;
//        for(int i =0; i < s.length(); i++) {
//            for (int j=i ; j<s.length() ; j++) {
//                if (isPalindrome[i][j]) {
//                    for(int k =j+1; k < numOfPalindromsStartingAtIPosition.length; k++) {
//                        longAnswer +=numOfPalindromsStartingAtIPosition[k];
//                    }
//                }
//            }
//        }

        dp[s.length() - 1] = 1;
        for (int i=s.length()-2 ; i>=0 ; i--) {
            dp[i] = dp[i+1] + numOfPalindromsStartingAtIPosition[i];
        }

        int ans = 0;
        for (int i=0 ; i<s.length() ; i++) {
            for (int j=i ; j<s.length() ; j++) {
                if (isPalindrome[i][j] && j<s.length()-1)
                    ans += dp[j+1];
            }
        }
        //6 3 1 0
        //a a a

        return ans;
    }

    private boolean[][] palindromeMatrix(String s){
        boolean[][]result = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            result[i][i] = true;
        }
        for(int k = 1; k <=s.length(); k++) {
            for(int j = 0; j <= s.length()-k; j++) {
              if(k <= 2) {
                  if (s.charAt(j) == s.charAt(j+k-1))
                      result[j][j + k - 1] = true;
              }
              else if(s.charAt(j) == s.charAt(j+k-1)) {
                  result[j][j + k - 1] = result[j+1][j+k-2];
              }
            }
        }
        return result;
    }
}
