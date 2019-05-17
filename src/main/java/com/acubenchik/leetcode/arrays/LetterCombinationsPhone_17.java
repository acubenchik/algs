package com.acubenchik.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsPhone_17 {

    public static void main(String[] args) {
        new LetterCombinationsPhone_17().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});
        List<String> result = new ArrayList<>();
        visit(dict, result, digits, 0, "");
        return result;
    }

    public void visit(HashMap<Character, char[]> dict, List<String> result, String  digits,  int index, String currentResult){

        if(currentResult.length() == digits.length()) {
            result.add(currentResult);
            return;
        }
        char c = digits.charAt(index);
        for(char next : dict.get(c)) {
            visit(dict, result, digits, index+1, currentResult + next);
        }
    }
}
