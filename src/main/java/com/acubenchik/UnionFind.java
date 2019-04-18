package com.acubenchik;

public class UnionFind {

//    private int[] adjList;

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] M) {
        int [] sets = new int[M.length];
        for(int i = 0; i < sets.length; i++) {
            sets[i] = i;
        }
        for(int i =0; i < M.length; i++) {
            for(int j=0; j < M[i].length; j++) {
                if(M[i][j] == 1) {
                    union(sets, i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < sets.length; i++) {
            if(sets[i] == i) count++;

        }
        return count;
    }

    public void union(int[] sets, int i, int j) {
        int iRoot = root(sets, i);
        int jRoot = root(sets, j);
        sets[iRoot] = jRoot;

    }


    public int root(int[] sets, int source){
        while(sets[source] != source) source = root(sets, sets[source]);
        return source;
    }
}
