package com.acubenchik;

public class KMPTemp {

    int[] prefix(String pattern) {
        int[] result = new int[pattern.length() + 1];
        result[0] = -1;
        int currentIndex = 0;
        int currentBorder = -1;
        while(currentIndex < pattern.length()) {
            while(currentBorder > 0 && pattern.charAt(currentIndex) != pattern.charAt(currentBorder)) {
                currentBorder = result[currentBorder];
            }
            currentIndex++;
            currentBorder++;
            result[currentIndex] = currentBorder;
        }
        return result;
    }


    void search(String pattern, String text) {
        int [] table = prefix(pattern);
        int currentIndex = 0;
        int j =0;
        while(currentIndex < text.length()) {
            while(j >= 0 && text.charAt(currentIndex)!=pattern.charAt(j)) {
                j = table[j];
            }
            j++;
            currentIndex++;
            if(j == pattern.length()) {
                System.out.println(currentIndex-j);
            }
        }
    }

}
