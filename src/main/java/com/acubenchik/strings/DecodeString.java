package com.acubenchik.strings;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
public class DecodeString {

    public static void main(String[] args) {
        String res = new DecodeString().decodeString("3[a2[c]]");
        System.out.println(res);
    }

    public String decodeString(String s) {
        String result = "";
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
           if(Character.isDigit(s.charAt(i))) {
               int num = 0;
               while(Character.isDigit(s.charAt(i))) {
                   num = num * 10 + (s.charAt(i) - '0');
                   i++;
               }
               numberStack.push(num);
           } else if(s.charAt(i)=='[') {
               stringStack.push(result);
               i++;
               result = "";

           } else if(s.charAt(i) == ']') {
               String newWord = "";
               int times = numberStack.pop();
               for (int j = 0; j < times; j++) {
                   newWord += result;
               }
               String previous = stringStack.pop();
               result = previous + newWord;
               i++;
           } else {
               result += s.charAt(i);
               i++;
           }
       }
       return result;
    }


}
