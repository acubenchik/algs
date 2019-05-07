package com.acubenchik.strings;

public class BoyerMoore {

    public static void main(String[] args) {
        System.out.println(new BoyerMoore().find("abc", "ddabcrr"));
    }

    int find(String pattern, String text) {
        int [] rightMostPositions = new int[256];
        for (int i = 0; i < rightMostPositions.length; i++) {
            rightMostPositions[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            rightMostPositions[pattern.charAt(i)] = i;
        }
        int move;
        for (int i = 0; i < text.length() - pattern.length(); i+=move) {
            move = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if(pattern.charAt(j) != text.charAt(i+j)) {
                    move = j - rightMostPositions[text.charAt(i+j)];
                    if(move < 1) move = 1;
                    break;
                }
            }
            if(move == 0) return i;
        }
        return 0;
    }
}
