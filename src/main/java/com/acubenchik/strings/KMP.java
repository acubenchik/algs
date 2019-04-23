package com.acubenchik.strings;

public class KMP {

    public static void main(String[] args) {
        new KMP().kmpSearch("catacb#bcatac", "ababadababaa");
    }


    public int[] prefix(String pattern) {
        int [] result = new int[pattern.length() +1];
        int currentIndex = 0;
        int currentBorder = -1;
        result[0] = currentBorder;
        while( currentIndex < pattern.length()) {
           while(currentBorder >=0 && pattern.charAt(currentIndex)!= pattern.charAt(currentBorder)) {
                currentBorder = result[currentBorder];
           }
            currentIndex++;
            currentBorder++;
            result[currentIndex] = currentBorder;
        }
        return result;
    }

//    public int[] prefix(String m) {
//        int [] prefixArray = new  int[m.length()+1];
//        int currentPos=0;
//        int nextSymbolOfPrefixPositionAndPrefixLength=-1;
//        prefixArray[currentPos]=nextSymbolOfPrefixPositionAndPrefixLength;
//        while (currentPos<m.length())
//        {
//            while (nextSymbolOfPrefixPositionAndPrefixLength>=0 && m.charAt(currentPos)!=m.charAt(nextSymbolOfPrefixPositionAndPrefixLength)) {
//                nextSymbolOfPrefixPositionAndPrefixLength = prefixArray[nextSymbolOfPrefixPositionAndPrefixLength];
//            }
//            currentPos++;
//            nextSymbolOfPrefixPositionAndPrefixLength++;
//            prefixArray[currentPos]=nextSymbolOfPrefixPositionAndPrefixLength;
//        }
//        return prefixArray;
//    }



    void kmpSearch(String pattern, String text)
    {
        int [] b = prefix(pattern);
        int currentIndex=0, j=0;
        while (currentIndex < text.length())
        {
            while (j >= 0 && text.charAt(currentIndex) != pattern.charAt(j)) {
                j=b[j];
            }
            currentIndex++;
            j++;
            if (j == pattern.length())
            {
                System.out.println(currentIndex-j);
                j = b[j];
            }
        }
    }
}
