package com.acubenchik.strings;

public class Manachers {

    public static void main(String[] args) {
        String res = new Manachers().longestPalindrome("adcb");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        char[] str = addDelimiters(s);
        int [] radiuses = new int[str.length];
        int rightBorder = 0;
        int previousCenter  = 0;
        int maxSubsPosition = 0;
        for(int currentCenter = 0; currentCenter < str.length; currentCenter++) {
            int mirror  = 2 * previousCenter - currentCenter;
            if(currentCenter < rightBorder) {
                radiuses[currentCenter] = Math.min(rightBorder - currentCenter,  radiuses[mirror]);
            }

            while(currentCenter + (1 + radiuses[currentCenter]) < str.length && currentCenter - (1+ radiuses[currentCenter]) >=0 &&
                    str[currentCenter + (1 + radiuses[currentCenter])] ==  str[currentCenter - (1+ radiuses[currentCenter])]) {
                radiuses[currentCenter]++;
            }
            if(radiuses[currentCenter] > radiuses[maxSubsPosition]) {
                maxSubsPosition = currentCenter;
            }
            int newBorder = currentCenter +  radiuses[currentCenter];
            if(newBorder > rightBorder) {
                previousCenter = currentCenter;
                rightBorder = newBorder;
            }
        }
        return s.substring((maxSubsPosition - radiuses[maxSubsPosition])/2, (maxSubsPosition + radiuses[maxSubsPosition])/2);
    }

    char[] addDelimiters(String s) {
        char[] result = new char[s.length()*2 + 1];
        int j = 1;
        result[0] = '|';
        for(int   i = 0; i < s.length(); i++) {
            result[j++] = s.charAt(i);
            result[j++] = '|';

        }
        return result;
    }
}
